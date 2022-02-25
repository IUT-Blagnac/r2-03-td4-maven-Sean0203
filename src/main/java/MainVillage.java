package test;

import java.util.ArrayList;
import java.util.Arrays;

import lesschtroumpfs.Village;

public class MainVillage {

	/**
	* Main du programme
	* @param argv tableaux d'arguments
	*
	*/
	public static void main (String[] argv) {
		// Init du village
		ArrayList<String> listeNomsStmpfs = new ArrayList<String>(Arrays.asList("Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur à lunettes",
        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf étonné", "Schtroumpf acrobate", "Schtroumpf paresseux"));
		
		Village villageStmpf;
		
		villageStmpf = new Village("LeVillage", 0, listeNomsStmpfs);
		
		// Festival du solstice d'été
		villageStmpf.solstice_d_ete();
		
		//Présentation du chef du village
		System.out.println("Voici le chef du village:");
		villageStmpf.chefDuVillage().sePresenter();
		
		//Envoyer les Schtroumpfs au travail
		villageStmpf.envoyerAuTravail();
		
		//Les Schtroumpfs heureux se présentent et chantent
		villageStmpf.schtroumpsfHeureux();
		
		
		System.out.println("===================================");
		
		
		//rammassage
		villageStmpf.envoyerCueillirSalsepareille();
		
		// fête
		
		villageStmpf.solstice_d_ete();
		
		//Dîner
		villageStmpf.dinerTousEnsemble();
		
		// fête
		villageStmpf.solstice_d_ete();
	}
}

























//