package Player;

import java.util.ArrayList;

// This class keeps track of the player's stats, inventory, and other infomation.
public class Player {
	private int NEW_LEVEL = 10; // Amount of experience points needed to reach the next level
	private double LEVEL_INCREASE_RATIO = 1.1; // The ratio of experience points the next level will be compared to the previous
	
	private int START_HEALTH = 100; // Player's initial health.

	public String fName; // first name
	public String lName; // last name
	public int level; // player's level
	public int exp; // player's experience points until next level
	public int health; // current player health
	public int healthCeil; // Ceiling value (max value) of player's health
	public ArrayList<Attack> attacks = new ArrayList<Attack>(1); // List that contains the player's attacks.
	public ArrayList<Spell> spells = new ArrayList<Spell>(0); // List that contains the player's spells. Initially empty.

	/*
	 * Initializes the Player.
	 * @param first name
	 * @param last name
	 * @return new player object.
	 */
	public Player(String fn, String ln) {
		fn = fName;
		ln = lName;
		level = 1;
		exp = 0;
		healthCeil = START_HEALTH; // What player's ceiling health value starts out as.
		health = healthCeil; // What current health of the player starts out as.
		//attacks.add(new Attack("Fists", Melee, 1, -1); // Player begins the game with melee attack.
	}

	/*
	 * Sets the first name.
	 * @param first name
	 */
	public void setFName(String s) {
		s = fName;
	}

	/*
	 * Gets the first name.
	 * @return first name.
	 */
	public String getFName() {
		return fName;
	}

	/*
	 * Sets the last name.
	 * @param new last name
	 */
	public void setLName(String s) {
		s = lName;
	}

	/*
	 * Gets the last name.
	 * @return last name.
	 */
	public String getLName() {
		return lName;
	}
	
	/*
	 * Gets the player name.
	 * @return player's full name.
	 */
	public String getName() {
		return fName + " " + lName;
	}

	/*
	 * Sets the player level.
	 * @param desired player level
	 */
	public void setLevel(int n) {
		n = level;
	}

	/*
	 * Gets the player level
	 * @return player level
	 */
	public int getLevel() {
		return level;
	}
	
	/*
	 * Sets the player health.
	 * @param desired player health
	 */
	public void setHealth(int h) {
		h = health;
	}
	
	/*
	 * Gets the health of the player
	 * @return player health
	 */
	public int getHealth() {
		return health;
	}
	
	/*
	 * Lowers the player health
	 * @param damage received
	 * @return health points after damage
	 */
	public int lowerHealth(int dam) {
		return health - dam;
	}
	
	/*
	 * Raises the player health
	 * Will not raise the player health above the health ceiling (max health)
	 * @param health points received
	 * @return health points after healing
	 */
	public int raiseHealth(int p) {
		if ((health + p) > healthCeil) { // If current health plus health received is more than ceiling.
			return healthCeil; // Return the max amount of health (so health does not go above ceiling)
		}
		return health + p; // Otherwise points given to player health and increments health points.
	}
	
	/*
	 * Sets health ceiling
	 * Player health cannot be more than health ceiling
	 * @param new health ceiling
	 */
	public void setHealthCeil(int h) {
		h = healthCeil;
	}
	
	/*
	 * Gets health ceiling
	 * @return health ceiling
	 */
	public int getHealthCeil() {
		return healthCeil;
	}
	
	/*
	 * Lowers health ceiling
	 * @param damage received
	 * @return health ceiling after damage received
	 */
	public int lowerHealthCeil(int dam) {
		return healthCeil - dam; // Damage taken and decrements max health points that can be reached.
	}
	
	/*
	 * Raises health ceiling
	 * @param health ceiling points received
	 * @return current celing plus desired amount of ceiling added
	 */
	public int raiseHealthCeil(int p) {
		return health + p; // Points given and increments max health points that can be reached.
	}

	/*
	 * Increment level of the player if experience points hit experience ceiling for current level
	 * Decrements experience points by power of level ceiling
	 * @print level up message
	 */
	public void levelUp() {
		while (exp > NEW_LEVEL) { // While current experience points is more than the current level can hold
			exp -= NEW_LEVEL; // Subtract level ceiling from current experience points
			level++; // Raise level of player by 1
			System.out.println(getName() + " has now reached level " + level "!"); // Level up message
		}
	}

	/*
	 * Sets the amount of experience points
	 * @param desired amount of experience points
	 */
	public void setExp(int n) {
		n = exp;
	}

	/*
	 * Gets the amount of experience points
	 * @return amount of experience points
	 */
	public int getExp() {
		return exp;
	}
	
	/*
	 * Increment experience points of the player
	 * Adds earned points to current experience points
	 * @param earned experience points
	 * @print experience points earned message
	 */
	public void expUp(int earned) {
		exp += earned; // Add earned points to current points
		System.out.println(getName() + " has earned " + earned + " experience points."); // Experience earned message
		levelUp();
	}
	
	public int getExpToNextLevel() {
		return NEW_LEVEL - exp; // Amount of experience until next level
	}

	public void expUp(int earnedExp) {
		exp += earnedExp; // New amount of experience points = current exp + what was just earned
		if (exp > NEW_LEVEL) // If current experience points is more than what is needed to reach the next level
			levelUp();
	}
	
	@Override
	public String toString() {
		return getName() 
				+ "\nLevel: " + level 
				+ "\nExperience: " + exp 
				+ "\nExperience until Level " + (level + 1) + ": " + getExpToNextLevel() 
				+ "\nHealth remaining: " + health
				+ "\nAttacks: " + toStringAttacks() 
				+ "\nSpells: " + toStringSpells();
	}

	// Prints the attacks list.
	public String toStringAttacks() {
		if (attacks.isEmpty())
			return "None"; // Print "N/A" if there are no attacks
		else
			return attacks.toString(); // Print normally
	}
	
	// Prints the spells list.
		public String toStringSpells() {
			if (spells.isEmpty())
				return "None"; // Print "N/A" if there are no spells
			else
				return spells.toString(); // Print normally
		}
}