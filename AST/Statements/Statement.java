package AST.Statements;

import AST.Types.NodeType;

public class Statement {
    public NodeType kind;
    
    public Statement(NodeType kind){
        this.kind = kind;
    }
    
    @Override
    public boolean equals(Object stmt){
        if (stmt.getClass() != Statement.class) return false; 
        else return this.kind.equals(((Statement) stmt).kind);
    }
    
}
