package Parser;

import java.util.ArrayList;

import org.junit.*;

import AST.Statements.NumericLiteral;
import AST.Statements.Statement;
import AST.Statements.Program;

public class ParserTests {
    @Test
    public void parseNum(){
        Parser prs = new Parser();

        Program ast = prs.produceAST("2");

        ArrayList<Statement> body = new ArrayList<>();
        body.add(new NumericLiteral(2.0));
        Program expAst = new Program(body); 


        Assert.assertEquals(ast, expAst);
    }
}
