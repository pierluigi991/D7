package esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubricaTelefonica {

	private Map<String, String> rubrica = new HashMap<>();

	public void inserisciContatto(String nome, String telefono) {
		rubrica.put(nome, telefono);
	}

	public void cancellaContatto(String nome) {
		rubrica.remove(nome);
	}

	public String cercaNome(String telefono) {
		for (Map.Entry<String, String> entry : rubrica.entrySet()) {
			if (entry.getValue().equals(telefono)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public String cercaTelefono(String nome) {
		return rubrica.get(nome);
	}

	public void stampaRubrica() {
		for (Map.Entry<String, String> entry : rubrica.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		RubricaTelefonica rubrica = new RubricaTelefonica();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nScegli un'opzione:");
			System.out.println("1. Aggiungi contatto");
			System.out.println("2. Cancella contatto");
			System.out.println("3. Cerca numero di telefono");
			System.out.println("4. Cerca nome");
			System.out.println("5. Stampa rubrica");
			System.out.println("6. Esci");
			System.out.print("Opzione: ");
			int opzione = scanner.nextInt();
			scanner.nextLine();

			if (opzione == 1) {
				System.out.print("Inserisci il nome: ");
				String nome = scanner.nextLine();
				System.out.print("Inserisci il numero di telefono: ");
				String telefono = scanner.nextLine();
				rubrica.inserisciContatto(nome, telefono);
				System.out.println("Contatto aggiunto!");
			} else if (opzione == 2) {
				System.out.print("Inserisci il nome del contatto da cancellare: ");
				String nome = scanner.nextLine();
				rubrica.cancellaContatto(nome);
				System.out.println("Contatto cancellato!");
			} else if (opzione == 3) {
				System.out.print("Inserisci il nome della persona di cui vuoi cercare il numero di telefono: ");
				String nome = scanner.nextLine();
				String telefono = rubrica.cercaTelefono(nome);
				if (telefono != null) {
					System.out.println("Numero di telefono di " + nome + ": " + telefono);
				} else {
					System.out.println("Contatto non trovato!");
				}
			} else if (opzione == 4) {
				System.out.print("Inserisci il numero di telefono della persona di cui vuoi cercare il nome: ");
				String telefono = scanner.nextLine();
				String nome = rubrica.cercaNome(telefono);
				if (nome != null) {
					System.out.println("Nome della persona con il numero " + telefono + ": " + nome);
				} else {
					System.out.println("Contatto non trovato!");
				}
			} else if (opzione == 5) {
				rubrica.stampaRubrica();
			} else if (opzione == 6) {
				break;
			}
		}

		scanner.close();
	}

}

