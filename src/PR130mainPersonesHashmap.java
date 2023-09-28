import java.util.HashMap;
import java.util.Map;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class PR130mainPersonesHashmap{
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("Pablo", 21);
        hashMap.put("Tania", 22);
        hashMap.put("Hugo", 17);
        hashMap.put("Carlos", 40);
        hashMap.put("Maria", 98);

        try{
            FileOutputStream fos = new FileOutputStream("PR130persones.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                dos.writeUTF(entry.getKey());
                dos.writeInt(entry.getValue());
            }
            fos.close();
            dos.close();

            FileInputStream fin = new FileInputStream("PR130persones.dat");
            DataInputStream dis = new DataInputStream(fin);

            for (int i=0; i< hashMap.size(); ++i){
                System.out.print(dis.readUTF() + ", ");
                System.out.println(dis.readInt());
            }

        }catch (IOException e) { e.printStackTrace(); }
    }
}
