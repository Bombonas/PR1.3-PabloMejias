import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

public class PR130mainPersonesHashmap implements Serializable{
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("Pablo", 21);
        hashMap.put("Tania", 22);
        hashMap.put("Hugo", 17);
        hashMap.put("Carlos", 40);
        hashMap.put("Maria", 98);

        try{
            FileOutputStream fos = new FileOutputStream("PR130persones.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hashMap);
            oos.close();
            fos.close();
            
            FileInputStream is = new FileInputStream("PR130persones.dat");
            ObjectInputStream ois = new ObjectInputStream(is);
            HashMap<String, Integer> nouHasMap = (HashMap<String, Integer>) ois.readObject();

            System.out.println(nouHasMap);
            ois.close();
            is.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) { e.printStackTrace(); }
    }
}
