package personnages;

import Objet.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement [2];
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	public String getNom () {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() +"\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le romain "+ nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert (forceCoup>=0);
		int forceDeb=force;
		force = force - forceCoup;
		if(force<1) {
			parler("J'abandonne ! ");
		}
		else {
			parler("Aie");
		}
		assert (forceDeb>=force);
	}
	private boolean isInvariantVerified() {
		return (force>=0);
		}
	
	private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipements] = equipement;
        this.nbEquipements++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
        case 2:
            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
            break;
        case 1:
            if (equipements[0] == equipement) {
                System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
            } else {
                ajouterEquipement(equipement);
            }
            break;
        case 0:
        default:
            ajouterEquipement(equipement);
            break;
    }
	}

	public static void main(String args[]) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);
        
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
	}
}

