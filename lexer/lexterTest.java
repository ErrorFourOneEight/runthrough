package Lexer;
import java.util.ArrayList;

import org.junit.*;

import Lexer.Types.ShiftableArray;
import Lexer.Types.Token;
import Lexer.Types.TokenType;


public class lexterTest {
    @Test
    public void testShiftable(){
        ShiftableArray<String> arr = new ShiftableArray<String>();
        arr.add("a"); arr.add("b"); arr.add("c");
        
        ShiftableArray<String> finArr = new ShiftableArray<String>();
        finArr.add("b"); finArr.add("c");
        
        Assert.assertEquals(arr.shiftVals(), "a");
        Assert.assertArrayEquals(arr.toArray(), finArr.toArray());
        
    }

    @Test
    public void testIsInt(){
        Assert.assertEquals(Lexer.isInt("1234"), true);
        Assert.assertEquals(Lexer.isInt("123a"), false);

    }

    @Test
    public void testIsAlpha(){
        Assert.assertEquals(Lexer.isAlpha("Hello"), true);
        Assert.assertEquals(Lexer.isAlpha("no way!"), false);

    }

    @Test
    public void testIsSkippable(){
        Assert.assertEquals(Lexer.isSkippable(" \n \t"), true);
        Assert.assertEquals(Lexer.isSkippable(" o "), false);

    }


    @Test
    public void getStr(){
        ShiftableArray<String> src = new ShiftableArray<>();
        src.add("A"); src.add("b"); src.add("1");

        Assert.assertEquals("Ab",Lexer.buildStr(src));
    }

    @Test
    public void getInt(){
        ShiftableArray<String> src = new ShiftableArray<>();
        src.add("1"); src.add("2"); src.add("G");

        Assert.assertEquals("12",Lexer.buildNum(src));
    }

    @Test
    public void lexerTest(){
        String source = "let x = 1 + 2";
        Lexer lex = new Lexer();

        ArrayList<Token> res = lex.tokenize(source);

        ArrayList<Token> expRes = new ArrayList<Token>();
        expRes.add(new Token("let", TokenType.Let));
        expRes.add(new Token("x", TokenType.Identifier));
        expRes.add(new Token("=", TokenType.Equals));
        expRes.add(new Token("1", TokenType.Number));
        expRes.add(new Token("+", TokenType.BinaryOperator));
        expRes.add(new Token("2", TokenType.Number));
        expRes.add(new Token("EOF", TokenType.EOF));


        System.out.println(Lexer.showTokens(res));

        while (res.size() > 0){
            Assert.assertEquals(res.get(0), expRes.get(0));
            res.remove(0); expRes.remove(0);
        }
        Assert.assertEquals(0, res.size());
        Assert.assertEquals(0, expRes.size());

    }

}
