
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Double a= 8.0;
    Double  b= 2.0;

    Calculatrice calculatrice = new Calculatrice();

    /* Premier jet avant de temps de faire une selection
        Voir l'implémentation d'un switch case
     */

    Double addition = calculatrice.addition(a, b);
    Double soustraction = calculatrice.soustraction(a, b);
    Double multiplication = calculatrice.multiplication(a,b);
    Double division =calculatrice.division(a, b);
    Double modulo = calculatrice.modulo(a, b);
    Double reset = calculatrice.reset(a,b);



    /* gestion des erreurs à implémenter (div et modulo par 0)
    A voir selon le temps si simple message d'erreur
    ou
    tentative de try/catch */


    //Affichage des résultats
    System.out.println("addition: "+addition);
    System.out.println("soustraction: "+soustraction);
    System.out.println("multiplication: "+multiplication);
    System.out.println("division: "+division);
    System.out.println("modulo: "+modulo);
    System.out.println("reset: "+reset);
    calculatrice.afficherHistorique();


    }


}