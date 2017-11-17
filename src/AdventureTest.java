import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdventureTest {

	@Test
	void test() {
		Adventure adventure = new Adventure("test.txt");
		adventure.disableMapOutput();
		
		String cmd = "go south";
		String expected = "Moving south...\n" + "You are at location 1,0";
		String actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "g south";
		expected = "Moving south...\n" + "You are at location 2,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "go inside";
		expected = "You can't go that way.\n" + "You are at location 2,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "go west";
		expected = "You can't go that far west.\n" + "You are at location 2,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "go south";
		expected = "Moving south...\n" + "You are at location 3,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "go south";
		expected = "Moving south...\n" + "You are at location 4,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "go south";
		expected = "You can't go that far south.\n" + "You are at location 4,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "inventory";
		expected = "You are carrying:\n" + "brass lantern\n" + "rope\n" + "rations\n" + "staff\n" + "You are at location 4,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "i";
		expected = "You are carrying:\n" + "brass lantern\n" + "rope\n" + "rations\n" + "staff\n" + "You are at location 4,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "foo";
		expected = "Invalid command: foo\n" + "You are at location 4,0";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "GO EAST";
		expected = "Moving east...\n" + "You are at location 4,1";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
		cmd = "Q";
		expected = "Farewell\n" + "You are at location 4,1";
		actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
		
	}

}
