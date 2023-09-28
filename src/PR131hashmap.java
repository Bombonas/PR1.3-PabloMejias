import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable{

    private HashMap<String, Integer> hashMap;

    public PR131hashmap(){
        this.hashMap = new HashMap<String,Integer>();
    }

    public void addHashMap(String name, Integer age){
        this.hashMap.put(name, age);
    }

    @Override
    public String toString(){
        return(this.hashMap.toString());
    }
}

