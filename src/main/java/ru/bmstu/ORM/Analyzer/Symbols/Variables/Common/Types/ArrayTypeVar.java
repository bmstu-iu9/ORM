package ru.bmstu.ORM.Analyzer.Symbols.Variables.Common.Types;

import ru.bmstu.ORM.Analyzer.Symbols.Variables.Var;
import ru.bmstu.ORM.Analyzer.Symbols.Variables.VarTag;

public class ArrayTypeVar extends Var {
    public ArrayTypeVar() {
        super(VarTag.ARRAY_TYPE);
    }
}