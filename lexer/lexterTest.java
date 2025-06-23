package lexer;
import java.util.ArrayList;

import org.junit.*;

import dataTypes.ShiftableArray;

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
        Assert.assertEquals(lexer.isInt("1234"), true);
        Assert.assertEquals(lexer.isInt("123a"), false);

    }

    @Test
    public void testIsAlpha(){
        Assert.assertEquals(lexer.isAlpha("Hello"), true);
        Assert.assertEquals(lexer.isAlpha("no way!"), false);

    }

    @Test
    public void testIsSkippable(){
        Assert.assertEquals(lexer.isSkippable(" \n \t"), true);
        Assert.assertEquals(lexer.isSkippable(" o "), false);

    }


    @Test
    public void getStr(){
        ShiftableArray<String> src = new ShiftableArray<>();
        src.add("A"); src.add("b"); src.add("1");

        Assert.assertEquals("Ab",lexer.buildStr(src));
    }

    @Test
    public void getInt(){
        ShiftableArray<String> src = new ShiftableArray<>();
        src.add("1"); src.add("2"); src.add("G");

        Assert.assertEquals("12",lexer.buildNum(src));
    }

    @Test
    public void lexerTest(){
        String source = "1 + 2";
        lexer lex = new lexer();

        ArrayList<Token> res = lex.tokenize(source);

        ArrayList<Token> expRes = new ArrayList<Token>();
        expRes.add(new Token("1", TokenType.Number));
        expRes.add(new Token("+", TokenType.BinaryOperator));
        expRes.add(new Token("2", TokenType.Number));

        System.out.println(lexer.showTokens(res));

        while (res.size() > 0){
            Assert.assertEquals(res.get(0), expRes.get(0));
            res.remove(0); expRes.remove(0);
        }
        Assert.assertEquals(0, res.size());
        Assert.assertEquals(0, expRes.size());

    }

}
