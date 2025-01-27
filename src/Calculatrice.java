import java.util.ArrayList;
import java.util.List;

public class Calculatrice {

    //implémentation de l'historique
    private static List<String> historique;

    public Calculatrice() {
        this.historique = new ArrayList<>();
    }


    public static double addition(double a, double b) {
        double resultat = a + b;
        historique.add("addition :"+a +" + "+b+" = "+resultat);
        return resultat;
    }

    public static double soustraction(double a, double b) {
        double resultat = a - b;
        historique.add("soustraction :"+a +" - "+b+" = "+resultat);
        return resultat;
    }


    public double multiplication(double a, double b) {
        double resultat = a * b;
        historique.add("multiplication: "+a +" * "+b+" = "+resultat);
        return resultat;
    }

    //cf Main concernant la gestion de div par 0
    public double division(double a, double b) {
        if (b == 0) {

        }
        double resulat = a / b;
        historique.add("division: "+a +" / "+b+" = "+resulat);
        return resulat;
    }

    //cf Main concernant la gestion de modulo par 0
    public double modulo(double a, double b) {
        if (b == 0) {

        }
        double resultat = a % b;
        historique.add("modulo: "+a +" % "+b+" = "+resultat);
        return resultat;
    }


    public double reset(double a, double b) {
        double resultat = 0.0;
        historique.add("reset: "+resultat);
        return resultat;
    }


    public void afficherHistorique() {
        System.out.println("historique: ");
        for (String h : historique) {
            System.out.println(h);
        }
    }
}
