package personnages;

import objets.Equipement;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified();
    }

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        int degats = calculerResistanceEquipement(forceCoup);
        force -= degats;
        if (force > 0) {
            parler("Aïe");
        } else {
            equipementEjecte = ejecterEquipement();
            parler("J'abandonne...");
        }
        return equipementEjecte;
    }

    private boolean isInvariantVerified() {
        return force >= 0;
    }

    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec " + equipement + ".");
    }

    public void sEquiper(Equipement equipement) {
        if (nbEquipement == 2) {
            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
        } else if (nbEquipement == 1 && equipements[0] == equipement) {
            System.out.println("Le soldat " + nom + " possède déjà " + equipement + " !");
        } else {
            ajouterEquipement(equipement);
        }
    }

    private int calculerResistanceEquipement(int forceCoup) {
        String texte = "Ma force est de " + force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0) {
            texte += "\nMais heureusement, grâce à mon équipement sa force ";
            for (int i = 0; i < nbEquipement; i++) {
                if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
                    resistanceEquipement += 6;
                } else {
                    resistanceEquipement += 3;
                }
            }
            if (resistanceEquipement >= forceCoup) {
                texte += "a été complètement absorbée.";
            } else {
                texte += "a été diminuée de " + resistanceEquipement + " !";
            }
        }
        parler(texte);
        return Math.max(0, forceCoup - resistanceEquipement);
    }

    private Equipement[] ejecterEquipement() {
        System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
        Equipement[] equipementEjecte = new Equipement[nbEquipement];
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] != null) {
                equipementEjecte[nbEquipementEjecte] = equipements[i];
                nbEquipementEjecte++;
                equipements[i] = null;
            }
        }
        nbEquipement = 0;
        return equipementEjecte;
    }

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);
        System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }
}