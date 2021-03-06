package ru.bmstu.ORM.Compiler.Analyzer.Symbols.Tokens;

import ru.bmstu.ORM.Compiler.Analyzer.Service.Fragment;
import ru.bmstu.ORM.Compiler.Analyzer.Service.Position;
import ru.bmstu.ORM.Compiler.Analyzer.Symbols.Symbol;

public abstract class Token<T> extends Symbol {
    private T value;

    public Token(TokenTag tag, Position start, Position follow, T value) {
        super(tag, new Fragment(start, follow));
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String getStringValue() {
        return value == null ? "null" : value.toString();
    }

    @Override
    public String toString() {
        return this.getTag() + " " + getCoords() + ": " + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Token other = (Token) obj;
        return this.getTag() == other.getTag() && this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return getTag().hashCode() * 31 + value.hashCode();
    }
}
