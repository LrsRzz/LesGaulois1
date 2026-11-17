package village_gaulois;

import objets.Equipement;
import objets.Trophee;
import personnages.Gaulois;

public class Musee {
    private Trophee[] trophees = new Trophee[200];
    private int nbTrophee = 0;

    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        trophees[nbTrophee] = new Trophee(gaulois, equipement);
        nbTrophee++;
    }

    public String extraireInstructionsOCaml() {
        StringBuilder instructions = new StringBuilder("let musee = [\n");
        for (int i = 0; i < nbTrophee; i++) {
            instructions.append("\"").append(trophees[i].donnerNom()).append("\", \"")
                    .append(trophees[i].getEquipement()).append("\"");
            if (i < nbTrophee - 1) {
                instructions.append(";");
            }
            instructions.append("\n");
        }
        instructions.append("]");
        return instructions.toString();
    }
}