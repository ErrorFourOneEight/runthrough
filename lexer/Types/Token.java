package Lexer.Types;

public class Token{
    public String value;
    public TokenType type;

    public Token(String val, TokenType type){
        this.value = val;
        this.type = type;
    }

    @Override
    public boolean equals(Object t1){
        if (t1.getClass() != Token.class)
            return false;

        Token tok = (Token) t1;
        return tok.value.equals(this.value) && tok.type == this.type ;
    }

    @Override
    public String toString(){
        String str = "\'" + this.value.toString() + "\' - " + this.type.toString();
        return str;
    }

}