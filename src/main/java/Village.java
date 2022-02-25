package lesschtroumpfs;

import java.util.ArrayList;

public class Village {
	private String nom;
	private ArrayList<Schtroumpf> habitants;
	private int nbHabitants;
	private int stockFeuilles;
	
	public Village (String pfNomV, int pfStockFeuilles, ArrayList<String> pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.stockFeuilles = pfStockFeuilles;
		this.habitants = new ArrayList<Schtroumpf>();
		
		// Initialisation de chaque Schtroumpf		
		Schtroumpf shpfAjouter;
		int age;
		String nomShpf;
		for(int i = 0; i < pfNomsDesSchtroumpfs.size(); i++) {
			age = (int)(Math.random()*150);
			nomShpf = pfNomsDesSchtroumpfs.get(i);
			
			shpfAjouter = new Schtroumpf(nomShpf, age, this);
			this.habitants.add(shpfAjouter);
		}
		
		this.nbHabitants = this.habitants.size();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbSchtroumpf() {
		return this.nbHabitants;
	}
	
	int getStockSalsepareille() {
		return this.stockFeuilles;
	}
	
	public void solstice_d_ete(){
		String chants = "";
		String message;
		int nbContents = 0;
		for(int i = 0; i < this.habitants.size(); i++) {
			if(this.habitants.get(i).estContent()) {
				nbContents ++;
			}
			
			chants += this.habitants.get(i).toString() + "\n";
			chants += this.habitants.get(i).leChant() + "\n\n";
		}
		
		message = "Pour le solstice d'été au village "+ this.nom +", il y a " + this.nbHabitants + " Schtroumpfs pésents,\ndont " + nbContents +" qui sont contents";
		message += "\n" + "Chacun va se présenter et chanter :\n" + chants;
		
		System.out.println(message);
	}
	
	public Schtroumpf chefDuVillage() {
		Schtroumpf plusAge = this.habitants.get(0);
		for(int i = 0; i < this.habitants.size(); i++) {
			if(this.habitants.get(i).getAge() > plusAge.getAge()) {
				plusAge = this.habitants.get(i);
			}
		}
		return plusAge;
	}
	
	public void envoyerAuTravail () {
		for(int i = 0; i < this.habitants.size(); i += 2) {
			this.habitants.get(i).allerTravailler();
		}
	}
	
	public void schtroumpsfHeureux () {
		System.out.println("Voici les Schtroumps heureux: \n");
		for(int i = 0; i < this.habitants.size(); i ++) {
			if(this.habitants.get(i).estContent()) {
				this.habitants.get(i).sePresenter();
				this.habitants.get(i).chanter();
			}
		}
	}
	
	//Methodes liées à la Salsepareille
	public void modifierStockFeuilles(int qte) throws Exception{
		if(this.stockFeuilles + qte < 0){
			throw new Exception ("Tentative de retrait de plus de feuilles qu'il n'y en a de disponibles");
		}
		else {
			this.stockFeuilles += qte;
		}
	}
	
	//Methodes liées à la Salsepareille
	public void dinerTousEnsemble() {
		for(int i = 0; i < this.habitants.size(); i ++) {
			try {
				this.habitants.get(i).dinerAuVillage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void envoyerCueillirSalsepareille() {
		int numEnvoyes = this.habitants.size() / 2;
		this.envoyerAuTravail();
		try {
			this.modifierStockFeuilles(numEnvoyes * 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}	




















