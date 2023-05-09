package esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MainListaCasuale {
	
	
	public static ArrayList<Integer> numeriRandom = new ArrayList<>();
	
	public static ArrayList<Integer> listaCasuale(int n) {		
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			numeriRandom.add(r.nextInt(100));
		}
		Collections.sort(numeriRandom);
		return numeriRandom;
	}
	
	
	public static ArrayList<Integer> listaDoppiaInversa(ArrayList<Integer> list) {
		ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
		Collections.reverse(clone);
		list.addAll(clone);
		return list;// la clono superficialmente e gli unisco il reverse ma mi esce questa unchecked che nn capisco
	}
	
	public static ArrayList<Integer> indicePariODispari(ArrayList<Integer> list, boolean b) {
		ArrayList<Integer> nuovoArray = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (b==true) {
				if (i%2 == 0) nuovoArray.add(list.get(i));
			} else {
				if (i%2 != 0) nuovoArray.add(list.get(i));
			}
		}
		return nuovoArray;
	}

	public static void main(String[] args) {
		
		int numero = 0;
		Scanner input = new Scanner(System.in);
		while (numero == 0) {
			try {
				System.out.println("Quanti numeri casuali vuoi che la lista contenga?");
				numero = Integer.parseInt(input.nextLine());
				if (numero < 1) throw new Exception();
			}
			//eccezioni esercizio di prima
			catch(NumberFormatException e) {
				System.out.println("Inserisci un numero intero positivo");
			}
			catch(Exception e) {
				System.out.println("Inserisci un numero maggiore di 0");
			}
		}
		System.out.println("Lista ordinata dei numeri generati: ");
		System.out.println(listaCasuale(numero));
		System.out.println("Lista ordinata + lista inversa dei numeri generati: ");
		System.out.println(listaDoppiaInversa(numeriRandom));
		System.out.println("Numeri generati di indice pari dell'ultima lista: ");
		System.out.println(indicePariODispari(numeriRandom, true));
		System.out.println("Numeri generati di indice dispari dell'ultima lista: ");
		System.out.println(indicePariODispari(numeriRandom, false));
		input.close();
		System.out.println(Collections.max(numeriRandom));
	}
}
