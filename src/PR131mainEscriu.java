import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PR131mainEscriu {
    
    public static void main(String[] args) {
        PR131hashmap pr131 = new PR131hashmap();

        pr131.addHashMap("Pablo", 21);
        pr131.addHashMap("Tania", 22);
        pr131.addHashMap("Hugo", 17);
        pr131.addHashMap("Carlos", 40);
        pr131.addHashMap("Maria", 98);

        try{
            FileOutputStream fos = new FileOutputStream("PR131HashMapData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pr131);
            oos.close();
            fos.close();
        }catch (IOException e) { e.printStackTrace(); }
    }
    
}
