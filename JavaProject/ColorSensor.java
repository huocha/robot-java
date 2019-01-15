package JavaProject;

import lejos.hardware.port.*;
import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class ColorSensor {
	
	// ATTRIBUTS
	public Port port;
	public EV3ColorSensor CSensor;
	
	// CONSTRUCTEUR
	public ColorSensor(){
		this.port = SensorPort.S3;
		this.CSensor = new EV3ColorSensor(SensorPort.S3);
	}
	
	public ColorSensor(Port port){
		this.port = port;
		this.CSensor = new EV3ColorSensor(port);
	}
	
	// METHODES
	// Vérification de la sortie
	public boolean verifcationSortie(){
		SampleProvider distance = CSensor.getColorIDMode();
		float[] sample = new float[distance.sampleSize()];
		distance.fetchSample(sample, 0);
		//System.out.println("Couleur : " + sample[0]);
		Delay.msDelay(500);
		
		if (sample[0] == 7){
			return true;
		} else {
			return false;
		}
	}

}
