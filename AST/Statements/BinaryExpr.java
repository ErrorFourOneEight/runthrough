package AST.Statements;

import AST.Types.NodeType;

public class BinaryExpr extends Expression {
    public Expression left;
    public Expression right;
    public String operator; 

    public BinaryExpr(Expression left, Expression right, String operator){
        super(NodeType.BinaryExpression);
        this.left = left;
        this.right = right; 
        this.operator = operator;
    }
    // add eq

}
