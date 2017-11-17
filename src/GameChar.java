import java.util.ArrayList;
import java.util.Arrays;

public class GameChar {
	private Map map;
	private Location location;
	ArrayList<String> inventory;
	int visability;
	
	public GameChar(Map map) {
		this.map = map;
		location = new Location(0,0);
		inventory = new ArrayList<String>(Arrays.asList("brass lantern", "rope", "rations", "staff"));
	}
	
	public String executeGoCommand(String cmdParam) {
		String direction = cmdParam;
		boolean validMove = false;
		if (direction.startsWith("n")) {
			validMove = move(0, -1);
			direction = "north";
		}
		else if (direction.startsWith("s")) {
			validMove = move(0, 1);
			direction = "south";
		}
		else if (direction.startsWith("e")) {
			validMove = move(1, 0);
			direction = "east";
		}
		else if (direction.startsWith("w")) {
			validMove = move(-1, 0);
			direction = "west";
		}
		else {
			//System.out.printf("Invalid direction: %s %n", direction);
			//return false;
			return "You can't go that way.\n";
		}
		if (validMove) {
			//System.out.printf("Moving %s... %n", direction);
			//return true;
			return "Moving " + direction + "...\n";
		}
		else {
			//System.out.printf("You can't go that far %s. %n", direction);
			//return false;
			return "You can't go that far " + direction + ".\n";
		}
	}
	
	public boolean move(int dx, int dy) {
		int newX = location.x + dx;
		int newY = location.y + dy;
		
		// Check if move is invalid.
		if (newX < 0 || newX >= map.getColumns() || newY < 0 || newY >= map.getRows()) {
			return false;
		}
		
		// Update x and y positions.
		location.x = newX;
		location.y = newY;
		
		return true;
	}
	
	public int getX() {
		return location.x;
	}
	
	public int getY() {
		return location.y;
	}
	
	public ArrayList<String> getInventory() {
		return inventory;
	}
	
	public String toString() {
		return String.format("%d,%d", location.x, location.y);
	}
}

