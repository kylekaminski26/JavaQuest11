package src;

import java.util.Scanner;

import Attack.Attack;
import Spell.Spell;

// This is how the game is run.
public class Driver {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Attack.InitAttacks(); // Initializes pre-made attacks.
		Spell.InitSpells(); // Initalizes pre-made spells.
		
		System.out.println("Enter your first name: ");
		String fname = sc.next();
		System.out.println("Enter your last name: ");
		String lname = sc.next();
		
		
		//Attack.InitAttacks();
		// Player.Player();
		
		Player player = new Player(fName, lName); // Initialize Player.
		
		//player.attacks.add(punch); // Gives Player the default attack.
		
		System.out.println("Welcome " + player.getFName() + " " + player.getLName() + "!");
		System.out.println("Here are your stats: \n" + player.toString());
		
	}
}
