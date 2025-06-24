package AST.Statements;

import AST.Types.NodeType;

public class NumericLiteral extends Expression {
    
    public Number value;


    public NumericLiteral(Number value){
        super(NodeType.NumericLiteral);
        this.value = value;
    }

    @Override
    public boolean equals(Object stmt){
        if (stmt.getClass() != NumericLiteral.class) return false; 
        else return this.kind.equals(((NumericLiteral) stmt).kind) && this.value.equals(((NumericLiteral) stmt).value);
    }
}
