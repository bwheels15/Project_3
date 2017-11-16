import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Adventure {
	private String mapFile;
	private Map map;
	private GameChar player;
	private final int VISABILITY = 1;
	
	public static void main(String[] args) {
		//String inputFile = "test.txt";
		String inputFile = "";
		
		//Get file name from command-line.
		if (args.length < 1) {
			System.out.println("No map file provided.");
	    }
	    else {
	    	inputFile = args[0];
	    }
		
		Adventure game = new Adventure(inputFile);
		game.playGame();
	}
	
	public Adventure(String inputFile) {
		mapFile = inputFile;
		
		// Create a Scanner object for file i/o.
		Scanner input = null;
		
		try {
			input = new Scanner(new File(mapFile));
	    } 
		catch (FileNotFoundException x) {
			System.out.println("File not found.");
	        x.printStackTrace();
	        System.exit(0);   // TERMINATE THE PROGRAM
	    }
		
		// Get map dimensions from first line in file.
		String[] mapSize = input.nextLine().split(" +");
		
		// Read in rows of characters for map terrain.
	    String line;
	    ArrayList<String> mapTerrains = new ArrayList<String>();
	    while (input.hasNextLine()) {
	    	line = input.nextLine();
	    	mapTerrains.add(line);
	    }
	    
	    // Create map.
	    map = new Map(mapSize, mapTerrains);
	    
		// Create player.
		player = new GameChar(map);
	}
	
	public void playGame() {
		// Create a Scanner object for file i/o.
		Scanner input = new Scanner(System.in);
		
		try {
			input = new Scanner(new File(mapFile));
	    } 
		catch (FileNotFoundException x) {
			System.out.println("File not found.");
	        x.printStackTrace();
	        System.exit(0);   // TERMINATE THE PROGRAM
	    }
		
		// Get map dimensions from first line in file.
		String[] mapSize = input.nextLine().split(" +");
		
		// Read in rows of characters for map terrain.
	    String line;
	    ArrayList<String> mapTerrains = new ArrayList<String>();
	    while (input.hasNextLine()) {
	    	line = input.nextLine();
	    	mapTerrains.add(line);
	    }
	    
	    // Create map.
	    map = new Map(mapSize, mapTerrains);
	    
	    // Alter Scanner object for user input.
	    input = new Scanner(System.in);
		
	    // Continue to prompt user for commands until "quit" is entered.
		boolean playGame = true;
		while (playGame == true) {
			// Prompt user to enter a command.
	        System.out.print("Enter a command: ");
	        String cmdString = input.nextLine().toLowerCase();
	        String[] cmdArray = cmdString.split(" +");
	        
	        String command = cmdArray[0];
	        String commandParam = "";
	        if (cmdArray.length == 2) {
	        	commandParam = cmdArray[1];
	        }

	        // Execute the command.
	        playGame = executeCommand(command, commandParam);
	    }
		
		input.close();
	}
	
	private boolean executeCommand(String cmd, String cmdParam) {
		boolean quiting = false;
		
		// Execute go command.
	    if (cmd.startsWith("g")) {
	    	player.executeGoCommand(cmdParam);
	    }
	    else if (cmd.startsWith("i")) {   // Execute inventory command.
	    	System.out.println("You are carrying:");
	    	for(String item : player.inventory) {
	    		System.out.println(item);
	    	}
	    }
	    else if (cmd.startsWith("q")) {   // Exit the program.
	    	System.out.println("Farewell");
	    	quiting = true;
	    }
	    else {   // Display Error message.
	    	System.out.printf("Invalid command: %s \n", cmd);
	    }
	    
	    int x = player.getX();
	    int y = player.getY();
	    System.out.printf("You are at location %d,%d in terrain %s \n", y, x, map.getTerrain(x,y));
	    
	    map.surroundingTerrain(x,y, VISABILITY);
	    
	    return !quiting;
	}
}
