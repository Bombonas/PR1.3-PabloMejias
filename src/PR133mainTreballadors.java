import java.util.List;
import java.util.Scanner;

public class PR133mainTreballadors {
    public static void main(String[] args) {

        List<String> csv = UtilsCSV.read("./src/PR133treballadors.csv");

        System.out.println(csv);

        int id = 0;
        Scanner sc = new Scanner(System.in);

        while(true){
            if(sc.hasNextInt()){
                id = sc.nextInt();
                break;
            }
        }
        String menu = "1)nom\n2)cognom\n3)Departament\n4)Salari";
        while(true){
            System.out.println(menu);
            if(sc.hasNextInt()){
                int option = sc.nextInt();
                if(option >0 && option <5){
                    
                }
            }
        }
    }
}
