package Parser;

import java.util.ArrayList;

import AST.Statements.*;
import Lexer.Lexer;
import Lexer.Types.ShiftableArray;
import Lexer.Types.Token;
import Lexer.Types.TokenType;

public class Parser {
    private static Lexer lex = new Lexer();
    private ShiftableArray<Token> tokens;


    private boolean notEOF(){
        return tokens.get(0).type != TokenType.EOF;
    }

    private Statement parseStatement(){
        // will have other types of statements

        return this.parseExpression();
    }

    private Expression parseExpression(){
        // will need to add more

        return parsePrimaryExpr();
    }

    private Token at(){
        return this.tokens.get(0);
    }

    private Token eat(){
        return this.tokens.shiftVals();
    }

    private Expression parsePrimaryExpr(){
        TokenType tk = this.at().type;

        switch (tk){
            case Identifier:
                return new Identifier(this.eat().value);
            case Number:
                return new NumericLiteral(Float.parseFloat(this.eat().value));

            default:
                System.err.println("Unexpected token during parsing: " + this.at().toString());
                System.exit(1);
                return null;
        }
    }

    public Program produceAST(String rawSrc){
        tokens = new ShiftableArray<Token>(lex.tokenize(rawSrc));
        Program program = new Program(new ArrayList<Statement>());

        while (this.notEOF()){
            program.body.add(this.parseStatement());
        }

        return program;        
    }
}
