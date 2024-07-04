/*
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in)
        //int fattoriale;
        System.out.println("inserisci il valore per l'operazione: ");
        int fattoriale = scanner.nextInt();
        System.out.println("hai inserito il valore: " + fattoriale + "quindi ");
        for (fatt)

    }
}

 */
import java.util.Scanner;

public class Fattoriale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int numero = scanner.nextInt();
        int fattoriale = 1;
        for (int i = 1; i <= numero; i++) {
            fattoriale *= i;
        }
        System.out.println("Il fattoriale di " + numero + " è: " + fattoriale);
    }
}
