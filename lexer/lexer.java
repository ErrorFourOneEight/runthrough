package Lexer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Lexer.Types.ShiftableArray;
import Lexer.Types.Token;
import Lexer.Types.TokenType;



public class Lexer {

    /**
     * Checks to see if an array contains the given value
     * 
     * @param arr The array being checked 
     * @param val The value being searched for
     * @return The result as a bool
     */
    public static Boolean contains(Object[] arr, Object val){
        return Arrays.stream(arr).anyMatch(val::equals);
    }

    /**
     * Checks if a string contains only alphabetic characters
     * 
     * @param str The string being checked
     * @return The result as a bool
     */ 
    public static Boolean isAlpha(String str){
        return str.matches("[a-zA-Z]+");
    }

    /**
     * Checks if a string only contains numbers
     * 
     * @param str The string being checked
     * @return The result as a bool
     */
    public static Boolean isInt(String str){
        return str.matches("-?\\d+");
    }

    /**
     * Returns true if the string only contains skippable characters
     * @param str The string being checked
     * @return The result as a bool
     */
    protected static Boolean isSkippable(String str){
        return str.matches("\\s+");
    }

    /**
     * Builds a number (as a string) from a shiftable array
     * @param src The shiftable array
     * @return The number as a string
     */
    protected static String buildNum(ShiftableArray<String> src){            
        String num = "";
        while (src.size() > 0 && isInt(src.get(0))){
            num = num + src.get(0);
            src.shiftVals();
        }
        return num;
    }

    /**
     * Builds a string from a shiftable array
     * @param src The shiftable array
     * @return The string as a string
     */
    protected static String buildStr(ShiftableArray<String> src){            
        String str = "";
        while (src.size() > 0 && isAlpha(src.get(0))){
            str = str + src.get(0);
            src.shiftVals();
        }
        return str;
    }

    /**
     * Returns a string based on the tokens given which is nicely formatted to assist with debugging
     * @param toks The token array 
     * @return A string version of the token array
     */
    public static String showTokens(ArrayList<Token> toks){
        String finStr = "";
        for (Token tok : toks){
            finStr = finStr + tok.toString() + "\n";
        }

        return finStr;
    }

    static String[] BINARYOPS = {"+", "-", "*", "/"};

    static HashMap<String, TokenType> KEYWORDS = new HashMap<String, TokenType>() {{
        put("let", TokenType.Let);
    }};


    public ArrayList<Token> tokenize(String rawData) {
        ArrayList<Token> tokens = new ArrayList<Token>();

        ShiftableArray<String> src = new ShiftableArray<String>();
        src.addAll(Arrays.asList(rawData.split("")));


        while (src.size() > 0){
            // build token
            String chr = src.get(0);

            // Single character tokens
            if (chr.equals("(")){
                tokens.add(new Token(src.shiftVals() , TokenType.OpenParen));
            } else if (chr.equals(")")){
                tokens.add(new Token(src.shiftVals() , TokenType.CloseParen));
            } else if (contains(BINARYOPS, chr)){
                tokens.add(new Token(src.shiftVals() , TokenType.BinaryOperator));
            } else if (chr.equals("=")){
                tokens.add(new Token(src.shiftVals() , TokenType.Equals));
            }

            // multi-character tokens
            else {
                // Builds Number
                if (isInt(chr)){
                    tokens.add(new Token(buildNum(src), TokenType.Number));
                }
                // Builds string
                else if (isAlpha(chr)){
                    String str = buildStr(src);

                    if (KEYWORDS.containsKey(str)){
                        // handle reserved words 
                        TokenType type = KEYWORDS.get(str);
                        tokens.add(new Token (str, type));
                    } else {
                        // must be identifier
                        tokens.add(new Token(str, TokenType.Identifier));
                    }
                } else if (isSkippable(chr)){
                    src.shiftVals();
                } else {
                    // catch-all for unrecognised symbols
                    System.err.println("Unauthorised character found: " + chr);
                    System.exit(1);
                }

            }

        }
        
        tokens.add(new Token("EOF", TokenType.EOF));
        return tokens;
    }
}

