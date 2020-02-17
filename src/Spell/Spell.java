package rpg;

public class Spell {
	
	String name;
	Type type; // Type of spell
	double damage; // Damage the spell deals
	int mana; // Mana cost
	
	public Spell(String n, Type t, double da, int m) {
		n = name;
		t = type;
		da = damage;
		m = mana;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
