package JavaProject;

public class Temps {

	// ATTRIBUTS
	public long start = 0;
	public long finish = 0;
	public long temps = 0;
	
	// CONSTRUCTEUR
	public Temps (){
		
	}
	
	// METHODES
	// début 
	public void begin(){
		this.start = System.currentTimeMillis();
	}
	
	// fin
	public void end(){
		this.finish = System.currentTimeMillis();
	}
	
	// calcul temps final
	public long calculTps(){
		this.temps = this.finish - this.start;
		return this.temps;
	}
}
