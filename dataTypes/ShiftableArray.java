package dataTypes;
import java.util.ArrayList;

public class ShiftableArray<V> extends ArrayList<V>{
    public V shiftVals(){
        V returnVal = this.get(0);
        this.remove(0);
        return returnVal;
    }
}
