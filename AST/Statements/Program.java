package AST.Statements;

import java.util.ArrayList;

import AST.Types.NodeType;

public class Program extends Statement{
    public ArrayList<Statement> body;

    public Program(ArrayList<Statement> body){
        super(NodeType.Program);
        this.body = body;
    }

    @Override
    public boolean equals(Object stmt){
        if (stmt.getClass() != Program.class) return false; 
        else return this.kind.equals(((Program) stmt).kind) && this.body.equals(((Program) stmt).body);
    }
}
