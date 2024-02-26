package lesschtroumpfs;

public class Schtroumpf {
	private String nom;
	private int age;
	private boolean etat;
	
	// village d'appartenance
	private Village village;
	
	/**
	* Constructeur d'un schtroumpf avec nom et age
	* @param pfNom nom du schtroumpf
	* @param pfAge age du schtroumpf
	*
	*/
	public Schtroumpf(String pfNom, int pfAge) {
		this.nom = pfNom;
		this.age = pfAge;
		this.etat = true;
		this.village = null;
	}
	
	/**
	* Constructeur d'un schtroumpf avec nom, age, et village
	* @param pfNom nom du schtroumpf
	* @param pfAge age du schtroumpf
	* @param pfVillage village de résidence du schtroumpf
	*/
	public Schtroumpf(String pfNom, int pfAge, Village pfVillage) {
		this.nom = pfNom;
		this.age = pfAge;
		this.etat = true;
		this.village = pfVillage;
	}
	
	/**
	* Récupère le nom du schtroumpf
	* @return un String représentant le nom
	*
	*/
	public String getNom() {
		return this.nom;
	}
	public int getAge() {
		return this.age;
	}
	
	public boolean estContent() {
		return this.etat;
	}
	
	public String toString() {
		String etatStrmph = " ";
		String villageDHabitation;
		if(! this.estContent()){
			etatStrmph = " PAS ";
		}
		if(this.village == null) {
			villageDHabitation = "je suis ermite";
		}
		else {
			villageDHabitation = "je viens du village " + this.village.getNom();
		}
		return "Bonjour, je suis " + this.nom + ", j’ai " + this.age  + " ans, je suis" + etatStrmph + "content, et " + villageDHabitation + ".";
	}
	
	public void sePresenter() {
		System.out.println(this.toString());
		
	}
	
	public String leChant() {
		if(this.estContent()){
			return "la, la, la Schtroumpf la, la";
		}
		else {
			return "gloups";
		}
	}
	
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	public void anniversaire() {
		this.age ++;
	}
	
	public void manger(int pfQte) {
		if(pfQte > 0) {
			this.etat = true;
		}
		if(this.village != null) {
			try {
				this.village.modifierStockFeuilles(pfQte * -1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void allerTravailler() {
		this.etat = false;
	}
	
	//Méthodes liées aux villages
	public Village getVillage() {
		return this.village;
	}
	
	public void setVillage(Village pfV) {
		this.village = pfV;
	}
	
	//Methodes liées à la Salsepareille
	public void recolterSalsepareille() {
		if(this.village == null) {
			this.manger(5);
		}
		else {
			try {
				this.village.modifierStockFeuilles(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dinerAuVillage() throws Exception{
		if(this.village == null) {
			throw new Exception ("Ce Schtroumpf n'habite pas dans un village");
		}
		if (this.village.getStockSalsepareille() > 3) {
			this.manger(3);
		}
		else {
			this.etat = false;
		}
	}
	
	
	
}












