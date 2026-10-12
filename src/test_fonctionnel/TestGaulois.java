package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		
		/*Test 1.2*/ 
		System.out.println("Test 1\n");
		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		
		/*Test 3.3*/
		System.out.println("\nTest 2\n");
		Romain minus = new Romain("Minus", 6);
		System.out.println("Dans la foret, "+asterix.toString()+" et "+obelix.toString()+" tombent nez à nez sur le Romain "+minus.getNom()+".\n");
		for(int i = 0;i<3;i++) {
			asterix.frapper(minus);
		}
		/*Test 4.5*/
		System.out.println("\nTest 3\n");
		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 2);
		panoramix.fabriquerPotion(4,3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		for(int j = 0;j<3;j++) {
			asterix.frapper(brutus);
		}
		
	}
}
