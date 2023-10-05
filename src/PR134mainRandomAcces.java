import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PR134mainRandomAcces {

    private static final int ID_SIZE = 4; // bytes
    private static final int CHAR_SIZE = 2; // bytes per caràcter en UTF-16
    private static final int NAME_SIZE = 20; // Longitud màxima en caràcters del nom
    static Scanner in = new Scanner(System.in); // System.in és global

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("./src/notesPR134.dat", "rw")) {
            boolean running = true;
            while (running) {
                String menu = "Escull una opció:";
                menu = menu + "\n 1) Nou alumne";
                menu = menu + "\n 2) Actualitzar nota";
                menu = menu + "\n 3) Consultar nota";
                menu = menu + "\n 4) Mostrar tots el alumnes";
                // Adapta aquí les altres classes de l’exercici (PR122cat…)
                menu = menu + "\n 100) Sortir";
                System.out.println(menu);


                int opcio = Integer.valueOf(llegirLinia("Opció:"));
                try {
                    int id;
                    switch (opcio) {
                    case 1: 
                        System.out.println("Nom: ");
                        String nom = in.nextLine();
                        System.out.println("Nota: ");
                        float nota = in.nextFloat();
                        in.nextLine();
                        afegirAlumne(raf, getId(raf), nom, nota);
                        break;
                    case 2: 
                        System.out.println("Id: ");
                        id = in.nextInt();
                        System.out.println("Nota: ");
                        float novaNota = in.nextFloat();
                        actualitzarNota(raf, id, novaNota);
                        in.nextLine();
                        break;
                    case 3: 
                        System.out.println("Id: ");
                        id = in.nextInt();
                        System.out.println("Nota: " + consultarNota(raf, id));
                        in.nextLine();
                        break;
                    case 4: 
                        for(int i = 0; i<raf.length(); i+=ID_SIZE*2+NAME_SIZE){
                            System.out.println(i);
                            raf.seek(i);
                            int idPrint = raf.readInt();
                            char[] chars = new char[NAME_SIZE];
                            for (int j = 0; j < NAME_SIZE; j++) {
                                chars[j] = raf.readChar();
                            }
                            float notaPrint =raf.readFloat();
                            System.out.println(idPrint + " " + new String(chars).trim() + " " + notaPrint);
                        }
                        System.out.println("salgo for");
                        break;
                    // Adapta aquí les altres classes de l’exercici (PR122cat…)
                    case 100: running = false; break;
                    default: break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            in.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }

    private static long getSeekPosition(int id) {
        return (id) * (ID_SIZE*2 + NAME_SIZE );
    }

    public static void afegirAlumne(RandomAccessFile raf, int id, String nom, float nota) throws Exception {
        raf.seek(raf.length());
        raf.writeInt(id);

        if (nom.length() > NAME_SIZE) {
            nom = nom.substring(0, NAME_SIZE);
        }
        nom = String.format("%1$-" + NAME_SIZE + "s", nom);

        raf.writeChars(nom);

        raf.writeFloat(nota);

    }

    public static void actualitzarNota(RandomAccessFile raf, int id, float novaNota) throws Exception {
        System.out.println(novaNota);
        raf.seek(getSeekPosition(id) + ID_SIZE + NAME_SIZE);
        raf.writeFloat(novaNota);
    }


    public static float consultarNota(RandomAccessFile raf, int id) throws Exception {
        raf.seek(getSeekPosition(id));
        raf.readInt();
        char[] chars = new char[NAME_SIZE];
        for (int i = 0; i < NAME_SIZE; i++) {
            chars[i] = raf.readChar();
        }
        return raf.readFloat();
    }

    public static int getId(RandomAccessFile raf) throws IOException{
        return (int) (raf.length()/(ID_SIZE*2+NAME_SIZE));
    }
}
