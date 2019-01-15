package JavaProject;

import java.io.File;

import lejos.hardware.*;
import lejos.hardware.lcd.Image;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class Robot {
	
	// ATTRIBUTS
	UnregulatedMotor roueGauche = new UnregulatedMotor(MotorPort.B);
	UnregulatedMotor roueDroite = new UnregulatedMotor(MotorPort.C);
	UltrasonicSensor USSensor;
	ColorSensor CSensor;
	
	// CONSTRUCTEUR
	public Robot(){
		this.USSensor = new UltrasonicSensor();
		this.CSensor = new ColorSensor();
	}
	
	public Robot(Port portUS, Port portCS){
		this.USSensor = new UltrasonicSensor(portUS);
		this.CSensor = new ColorSensor(portCS);
	}
	
	// METHODES
	// Avancer
	public void avancer(){
		// Vitesse réglée
		this.roueGauche.setPower(21);
		this.roueDroite.setPower(20);
		
		// Avancement
		this.roueGauche.forward();
		this.roueDroite.forward();
		Delay.msDelay(3400);
		
		// Amortissement
		this.roueGauche.flt();
		this.roueDroite.flt();
	}
	
	// Tourner à gauche
	public void tournerGauche(){
		// Vitesse réglée
		this.roueGauche.setPower(21); 
		this.roueDroite.setPower(20);
		
		// Avancement
		this.roueGauche.backward();
		this.roueDroite.forward();
		Delay.msDelay(1200); // tps à modifier
		
		// Amortissement
		this.roueGauche.flt();
		this.roueDroite.flt();
	}
	
	// Tourner à droite
	public void tournerDroite(){	
		// Vitesse réglée
		this.roueGauche.setPower(21);
		this.roueDroite.setPower(20);
		
		// Avancement
		this.roueGauche.forward();
		this.roueDroite.backward();
		Delay.msDelay(1200);
		
		// Amortissement
		this.roueGauche.flt();
		this.roueDroite.flt();
	}
	
	// Arrêt du motor et quitte
	public void arretMotor(){
		this.roueGauche.close();
		this.roueDroite.close();
	}
	
	// Bruitage de début de partie
	public void sonDebut(){
		for(int i=0;i<3;i++) {
			Sound.playTone(500, 800);
			Delay.msDelay(200);
		}
		Sound.playTone(1000, 800);
	}
	
	// Lance une musique
	public void joueMusique() {
	    File myFile = new File("pacman.wav");
	    Sound.playSample(myFile, 800);
	 }
	
	public void danse(){
		for (int i = 0 ; i < 6 ; i++){
			double nb = Math.random();
			double nb2 = (100 - 1) * nb + 1;
			int result = (int) Math.round(nb2);
			
			if (result > 50){
				tournerGauche();
			} else {
				tournerDroite();
			}
		}
	}
}
