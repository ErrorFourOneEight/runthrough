public class lexer {

    public enum TokenType{
        Number,
        Identifier,
        Equals, 
        
        OpenParen,
        CloseParen,
        BinaryOperator,
        
        Set,
    }

    public interface Token{
        String value,
        TokenType type
    }


    public ArrayList<Token> tokenize(String src) {
        ArrayList<Token> tokens = new ArrayList<Token>();


        return tokens
    }
}

