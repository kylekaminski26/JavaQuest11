package rpg;

public class Attack {
	
	public String name;
	public Type type; // Type of attack
	public double damage; // Damage the attack deals
	public double dur; // Attack durability.
	
	public Attack(String n, Type t, double da, double du) {
		n = name;
		t = type;
		da = damage;
		du = dur;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}