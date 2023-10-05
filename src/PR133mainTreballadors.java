import java.util.List;
import java.util.Scanner;

public class PR133mainTreballadors {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        List<String> csv = UtilsCSV.read("./src/PR133treballadors.csv");

        System.out.println(csv);
        
        System.out.println("ID: ");
        String id = sc.nextLine();
        int numLinia = UtilsCSV.getLineNumber(csv, "id", id);
        
        String menu = "Que vols canviar?\n1)nom\n2)cognom\n3)Departament\n4)Salari";
        System.out.println(menu);
        int opcio = Integer.valueOf(llegirLinia("Opció:"));
        try {
            switch (opcio) {
            case 1: 
                System.out.println("Nom: ");
                String nom = sc.nextLine();
                UtilsCSV.update(csv, numLinia, "nom", nom);
                break;
            case 2: 
                System.out.println("Cogom: ");
                String cognom = sc.nextLine();
                UtilsCSV.update(csv, numLinia, "cognom", cognom);
                break;
            case 3: 
                System.out.println("Departament: ");
                String departament = sc.nextLine();
                UtilsCSV.update(csv, numLinia, "departament", departament);
                break;
            case 4: 
                System.out.println("Salari: ");
                String salari = sc.nextLine();
                UtilsCSV.update(csv, numLinia, "salari", salari);
                break;
            default: break;
            }
            UtilsCSV.write("./src/PR133treballadors.csv", csv);
            System.out.println(csv);
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }

    static public String llegirLinia (String text) {
        System.out.print(text);
        return sc.nextLine();
      }
}
