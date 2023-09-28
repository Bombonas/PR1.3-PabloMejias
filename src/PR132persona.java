import java.io.Serializable;

public class PR132persona implements Serializable{
    private String nom;
    private String cognom;
    private int edat;

    public PR132persona(String nom, String cognom, int edat){
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public String toString(){
        return nom + ", " + cognom + ", " + edat;
    }
}
