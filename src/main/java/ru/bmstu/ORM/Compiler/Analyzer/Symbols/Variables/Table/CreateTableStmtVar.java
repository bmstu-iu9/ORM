package ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables.Table;

import ru.bmstu.ORM.Compiler.Analyzer.Symbols.SymbolType;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Tokens.IdentToken;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Tokens.TokenTag;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables.Common.QualifiedNameVar;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables.Common.Types.SimpleTypeNameVar;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables.Common.Types.TypenameVar;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables.Var;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables.VarTag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class CreateTableStmtVar extends Var {
    private QualifiedNameVar tableName;
    private LinkedHashMap<IdentToken, ColumnDefVar> columns;
    private ArrayList<TableConstraintVar> tableConstraints;
    private boolean existsPK;

    public CreateTableStmtVar() {
        super(VarTag.CREATE_TABLE_STMT);
        columns = new LinkedHashMap<>();
        tableConstraints = new ArrayList<>();
        existsPK = false;
    }

    public QualifiedNameVar getTableName() {
        return tableName;
    }

    public void setTableName(QualifiedNameVar tableName) {
        this.tableName = tableName;
    }

    public void addColumn(ColumnDefVar columnDef) {
        if (columns.containsKey(columnDef))
            throw new RuntimeException("Column " + columnDef.get(0) + " already exists");
        columns.put((IdentToken) columnDef.get(0), columnDef);
    }

    public SymbolType getTypeOfColumn(IdentToken colId) {
        TypenameVar typename = (TypenameVar) columns.get(colId).get(1);

        if (typename.size() == 2) {
            return TokenTag.ARRAY;
        } else {
            SimpleTypeNameVar simpleTypeName = (SimpleTypeNameVar) typename.get(0);
            return simpleTypeName.get(0).getTag();
        }
    }

    public ColumnDefVar getColumnDef(IdentToken colId) {
        return columns.get(colId);
    }

    public Collection<ColumnDefVar> getColumns() {
        return columns.values();
    }

    public boolean containsColumn(IdentToken colId) {
        return columns.containsKey(colId);
    }

    public ArrayList<TableConstraintVar> getTableConstraints() {
        return tableConstraints;
    }

    public void addTableConstraint(TableConstraintVar constraint) {
        tableConstraints.add(constraint);
    }

    @Override
    public String toString() {
        return this.getTag() + " " + getCoords() + ": " + tableName;
    }

    public SymbolType getFullTypeOfColumn(IdentToken colId) {
        TypenameVar typename = (TypenameVar) columns.get(colId).get(1);
        if (typename.size() == 2) {
            return TokenTag.ARRAY;
        } else {
            SimpleTypeNameVar simpleTypeName = (SimpleTypeNameVar) typename.get(0);
            return simpleTypeName.getFullType();
        }
    }

    public boolean isExistsPK() {
        return existsPK;
    }

    public void setExistsPK(boolean existsPK) {
        this.existsPK = existsPK;
    }

    public String getCatalog() {
        return this.tableName.getCatalog();
    }

    public String getSchema() {
        return this.tableName.getSchema();
    }

    public String getName() {
        return this.tableName.getName();
    }

    public ArrayList<ColumnDefVar> getPKs() {
        ArrayList<ColumnDefVar> res = new ArrayList<>(columns.values());
        res.removeIf(column -> !column.isPK());
        return res;
    }
}
