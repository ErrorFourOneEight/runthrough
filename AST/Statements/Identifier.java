package AST.Statements;

import AST.Types.NodeType;

public class Identifier extends Expression {
    public String symbol;

    public Identifier(String symbol){
        super(NodeType.Identifier);
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object stmt){
        if (stmt.getClass() != Identifier.class) return false; 
        else return this.kind.equals(((Identifier) stmt).kind) && this.symbol.equals(((Identifier) stmt).symbol);
    }
}
