package esercizio3;

import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {

	private static HashMap<String,String> rubrica = new HashMap<String,String>();
	
	
	public void inserisciContatto(String nome, String numero) {
		rubrica.put(nome, numero);
	};
	public void eliminaContatto(String nome) {
		rubrica.remove(nome);
	};
	public void cercaTramiteNumero(String numero) {
		for (String nome : rubrica.keySet()) {
			if (rubrica.get(nome).equals(numero)) {
				System.out.println(nome + ":" + numero);
			}
		}
	};
	public String cercaTramiteNome(String nome) {
		return rubrica.get(nome);
	};
	public void stampaRubrica() {
		System.out.println("Lista contatti: ");
		for (String nome: rubrica.keySet()) {
			String numero = rubrica.get(nome);
			System.out.println(nome + ": " + numero);

		}

	}
	public static void main(String[] args) {

		RubricaTelefonica rubrica = new RubricaTelefonica();

		rubrica.inserisciContatto("athos", "25558689");
		rubrica.inserisciContatto("porthos", "158788965");
		rubrica.inserisciContatto("aramis", "15557476");
	

		rubrica.stampaRubrica();

		rubrica.eliminaContatto("aramis");
		rubrica.stampaRubrica();

		rubrica.cercaTramiteNumero("15587896");
		rubrica.cercaTramiteNome("athos");

	}

	
	
}
