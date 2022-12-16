package org.example.minijava.ast;

import org.example.minijava.visitor.Visitor;
import org.example.minijava.visitor.TypeVisitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}