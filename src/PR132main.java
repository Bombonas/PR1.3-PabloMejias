import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;


public class PR132main {
    public static void main(String[] args) {

        PR132persona m = new PR132persona("Maria", "Lopez", 36);
        PR132persona g = new PR132persona("Gustavo", "Ponts", 63);
        PR132persona i = new PR132persona("Irene", "Sales", 54);

        ArrayList<PR132persona> arrayPers = new ArrayList<PR132persona>();

        try {
            FileOutputStream fos=new FileOutputStream("PR132people.dat");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            arrayPers.add(m);
            arrayPers.add(g);
            arrayPers.add(i);
            oos.writeObject(arrayPers);

            fos.close();
            oos.close();

            FileInputStream is = new FileInputStream("PR132people.dat");
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<PR132persona> arrayPersNou = (ArrayList<PR132persona>) ois.readObject();

            for (PR132persona pr132persona : arrayPersNou) {
                System.out.println(pr132persona);
            }
            
            ois.close();
            is.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
 
    }
}

