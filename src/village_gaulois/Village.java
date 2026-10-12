package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	public Village(String nom, Gaulois chef, int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.chef = chef;
		this.villageois = new Gaulois [NB_VILLAGEOIS_MAX];
		chef.setVillage(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		gaulois.setVillage(this);
		nbVillageois++;
	}
	public Gaulois trouverVillageois(int numVillageois) {
		if(numVillageois<=nbVillageois) {
			return villageois[numVillageois-1];
		}
		else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village "+getNom()+" du chef "+getChef()+" vivent les légendaires gaulois :");
		for(int i = 0; i<nbVillageois;i++) {
			System.out.println("- "+trouverVillageois(i+1));
		}
	}
	public static void main(String args[]) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles",abraracourcix,30);
		village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		
		System.out.println(gaulois);
		village.afficherVillageois();
		
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		
		Gaulois doublepolemix = new Gaulois("Doublepolémix",4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();

		
	}
}
