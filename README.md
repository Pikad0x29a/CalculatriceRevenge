# Rattrapage Calculatrice


Conception d'une pseudo-calculatrice en JAVA  
Sand design, sans clic, sans saisie utilisateur.

Affichage des résultats pour toutes les opérations. 

En cas de saisie utilisateur la mise en place d'un `swich case` aurait été plus pertinent du style:  
```java
 switch (operation) {
            case '+':
                resultat = calculatrice.addition(a, b);
                break;
            case '-':
                resultat = calculatrice.soustraction(a, b);
                break;
            case '*':
                resultat = calculatrice.multiplication(a, b);
                break;
            case '/':
                resultat = calculatrice.division(a, b);
                break;
            case '%':
                resultat = calculatrice.modulo(a, b);
                break;
            case 'r':
            case 'R':
                resultat = calculatrice.reset();
                a = b = 0; // Réinitialiser également les valeurs a et b si nécessaire
                break;
            default:
                System.out.println("Opération non valide");
                return; // Sortir du programme si l'opération est invalide
        }

        // Affichage des résultats
        System.out.println("Résultat de l'opération: " + resultat);
```
exemple de code inspiré de la doc citée en sources.

En lieu et place d'un `try-catch`qui générait des erreurs, j'ai opté pour la condition: 

```java
if (b == 0) {
            throw new ArithmeticException("division par zéro");
        }
```
Pour le cas de la division  
Et: 

```java
 if (b == 0)  {
            throw new ArithmeticException("Modulo par zero");
        }
```
Pour le cas du modulo.

⚠️ Après échange avec le formateur la gestion des erreurs par 0 n'a pas été demandée donc supprimée du projet.

## Code 

Dans le cas du `b = 0`:

### Main:  

```java
public class Main {
    public static void main(String[] args) {

    Double a= 8.0;
    Double  b= 0.0;

    Calculatrice calculatrice = new Calculatrice();

    /* Premier jet avant de temps de faire une selection
        Voir l'implémentation d'un switch case => cf README.md
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
    tentative de try/catch remplacée par throw new (cf README.md)
    Non prise en compte de la gestion par zéro suite à échange avec le formateur*/


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
```

### Classe Calculatrice:  

```java
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

```

### Affichage terminal:

```console
C:\Users\e2404309\[...]
addition: 8.0
soustraction: 8.0
multiplication: 0.0
division: Infinity
modulo: NaN
reset: 0.0
historique: 
addition :8.0 + 0.0 = 8.0
soustraction :8.0 - 0.0 = 8.0
multiplication: 8.0 * 0.0 = 0.0
division: 8.0 / 0.0 = Infinity
modulo: 8.0 % 0.0 = NaN
reset: 0.0
```




### Sources:

- [Switch case](https://www.programiz.com/java-programming/examples/calculator-switch-case)
- [Gestion des exceptions](https://codegym.cc/fr/groups/posts/fr.1102.java-lance-une-exception)
- [Choix entre IllegalArgumentException et ArithmeticException](https://medium.com/@jayram_manale/understanding-exceptions-in-java-a-complete-guide-to-error-handling-d644ade63d7d)