package JavaProject;

import lejos.hardware.port.*;
import lejos.utility.Delay;

public class Algorithme {
	
	// ATTRIBUTS
	public Robot robot;
	public Temps temps;
	
	// CONSTRUCTOR
	public Algorithme(){
		this.robot = new Robot();
		this.temps = new Temps();
	}
	
	public Algorithme(Port portUS, Port portCS){
		this.robot = new Robot(portUS,portCS);
		this.temps = new Temps();
	}
	
	public Algorithme(Robot r){
		this.robot = r;
		this.temps = new Temps();
	}
	

	// METHODES
	// Une boucle de l'algorithme
	public void tour(){
		
		if ( this.robot.USSensor.objetEnFace() == false ){ // Pas objet en face
			
			this.robot.tournerDroite();
			
			if (this.robot.USSensor.objetEnFace() == true ){ 
				this.robot.tournerGauche();
			}
			
		} else { // Objet en face
			
			this.robot.tournerDroite();
			
			if ( this.robot.USSensor.objetEnFace() == true ){
				this.robot.tournerGauche();
				this.robot.tournerGauche();
				
				if ( this.robot.USSensor.objetEnFace() == true ){
					this.robot.tournerGauche();	
				}
				
			} 
		}	

		this.robot.avancer();
	}
	
	
}
