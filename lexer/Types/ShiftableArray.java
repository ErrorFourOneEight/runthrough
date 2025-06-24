package Lexer.Types;
import java.util.ArrayList;

public class ShiftableArray<V> extends ArrayList<V>{
    
    public ShiftableArray(){
        super();
    }

    public ShiftableArray(ArrayList<V> arrLst){
        super(arrLst);
    }
    
    
    public V shiftVals(){
        V returnVal = this.get(0);
        this.remove(0);
        return returnVal;
    }
}
