package personnages;

import Objet.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron(0,0);
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() +  "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté "+quantite+" doses de potion magique. Elle a une force de "+forcePotion+".\n");
	}
	
	public void booster(Gaulois gaulois) {
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		if(contientPotion) {
			if(nomGaulois == "Obélix") {
				parler("Non, "+nomGaulois+" Non!... Et tu le sais très bien !");
			}
			else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens "+nomGaulois+" un peu de potion magique.");
			}
		}
		else {
			parler("Désolé "+nomGaulois+" il n'y a plus une seule goutte de potion.");
		}
	}
	
	public String getNom() {
		return nom;
	}
}

