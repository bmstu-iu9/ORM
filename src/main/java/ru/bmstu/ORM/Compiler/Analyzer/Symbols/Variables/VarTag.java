package ru.bmstu.ORM.Compiler.Analyzer.Symbols.Variables;

import ru.bmstu.ORM.Compiler.Analyzer.Symbols.SymbolType;

public enum VarTag implements SymbolType {
    S,
    CREATE_TABLE_STMT,
    CREATE_FUNCTION_STMT,
    CREATE_TABLE_FUNCTION_STMT,
    QUALIFIED_NAME,
    TABLE_ELEMENT,
    COLUMN_DEF,
    TABLE_CONSTRAINT,
    TYPENAME,
    ARRAY_TYPE,
    SIMPLE_TYPENAME,
    NUMERIC_TYPE,
    CHARACTER_TYPE,
    CHARACTER_KEYWORD,
    DATETIME_TYPE,
    COL_CONSTRAINT,
    CONSTRAINT_ELEM,
    COL_CONSTRAINT_ELEM,
    KEY_ACTIONS,
    KEY_ACTION,
    ARITHM_EXPR,
    ARITHM_EXPR_TERM,
    ARITHM_EXPR_FACTOR,
    BOOL_EXPR,
    BOOL_EXPR_TERM,
    BOOL_EXPR_FACTOR,
    RHS,
    ARITHM_RHS,
    BOOL_RHS,
    DATE_RHS,
    STRING_RHS,
    BOOL_CONST,
    CONST_EXPR,
    ARITHM_CONST_EXPR,
    ARITHM_CONST_EXPR_TERM,
    ARITHM_CONST_FACTOR,
    ARITHM_CONST_RHS,
    DATE_TIME_CAST,

    FUNC_ARGS_WITH_DEFAULTS_LIST,
    CREATE_FUNCTION_RETURN_STMT,
    CREATE_FUNC_BODY,
    TABLE_FUNC_COLUMN_LIST,
    FUNC_ARG_WITH_DEFAULT,
    FUNC_ARG,
    FUNC_ARG_DEFAULT,
    ARG_CLASS
}
