import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class PR131mainLlegeix {
    public static void main(String[] args) {
        
        try{
            FileInputStream is = new FileInputStream("PR131HashMapData.ser");
            ObjectInputStream ois = new ObjectInputStream(is);
            PR131hashmap nouHasMap = (PR131hashmap) ois.readObject();

            System.out.println(nouHasMap);
            ois.close();
            is.close();
        }catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) { e.printStackTrace(); }


    }
}
