package esercizio1;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class MainDuplicati {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> unaParola = new HashSet<>();
        Set<String> parolaDoppia = new HashSet<>();

        
        int n = 0;
        
        while (n == 0) {
			try {
				System.out.println("Inserisci il numero di parole da inserire in lista:");
				n = Integer.parseInt(scanner.nextLine());
				if (n < 1) throw new Exception();
			}
			catch(NumberFormatException e) {
				System.out.println("Non è stato inserito un numero intero");
			}
			catch(Exception e) {
				System.out.println("Occorre inserire un numero maggiore di 0");
			}
		}
		

        for (int i = 0; i < n; i++) {
            System.out.print("Inserisci la parola " + (i + 1) + ": ");
            String word = scanner.next();

            if (!unaParola.add(word)) {
            	parolaDoppia.add(word);
            }
        }

        System.out.println("Parole duplicate: " + parolaDoppia);
        System.out.println("Numero di parole distinte: " + unaParola.size());
        System.out.println("Elenco delle parole distinte: " + unaParola);
        scanner.close();
    }
	
}
