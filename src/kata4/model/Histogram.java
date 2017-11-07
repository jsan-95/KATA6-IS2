
package kata4.model;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
    private final Map<T,Integer> histogram = new HashMap<>(); 
    
    public int get(T key){
        return histogram.get(key);
    }
    
    public Set<T> keySet(){
        return histogram.keySet();
    }
    
    public void increment(T key, int value){
        histogram.put(key, histogram.containsKey(key)? histogram.get(key) + value : value);
    }
}
