package JavaProject;

import lejos.hardware.port.*;
import lejos.hardware.sensor.*;
import lejos.robotics.*;
import lejos.utility.Delay;

public class UltrasonicSensor {
	
	// ATTRIBUTS
	public Port port;
	public EV3UltrasonicSensor sensor;
	public int distanceControle = 20;

	// CONSTRUCTEURS
	public UltrasonicSensor(){
		this.port = SensorPort.S4;
		this.sensor = new EV3UltrasonicSensor(SensorPort.S4);
	}
	
	public UltrasonicSensor(Port port){
		this.port = port;
		this.sensor = new EV3UltrasonicSensor(port);
	}
	
	// METHODES
	// Détection si objet en face
	public boolean objetEnFace(){
		SampleProvider distance= sensor.getMode("Distance");
		float[] sample = new float[distance.sampleSize()];
		distance.fetchSample(sample, 0);
		sample[0] = sample[0] * 100;
		//System.out.println("Distance : " + sample[0]);
		Delay.msDelay(500);
		
		if (sample[0] <= this.distanceControle){
			//System.out.println("Objet en face");
			Delay.msDelay(1500);
			return true;
		} else {
			//System.out.println("Pas objet en face");
			Delay.msDelay(1500);
			return false;
		}
	}
}
