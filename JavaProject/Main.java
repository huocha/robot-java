package JavaProject;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {
		
		// Debut
		System.out.println("Appuyez sur n'importe quelle touche pour commencer.");
		Button.waitForAnyPress();
		
		// Instanciations objet
		Robot r = new Robot();
		Algorithme algo = new Algorithme(r);
		
		// Musique de début
		r.sonDebut();
		
		// Boucle algo
		while ( r.CSensor.verifcationSortie() != true ){
			algo.tour();
		}
		
		// Musique de fin
		r.joueMusique();
		r.danse();
		
		// Temps final
		algo.temps.end();
		System.out.println("Votre temps est de : " + algo.temps.calculTps()	 + "ms");
		Delay.msDelay(2500);
		
		// Quitte moteur
		r.arretMotor();
	}

}
