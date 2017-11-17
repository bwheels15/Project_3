import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdventureTest {

	@Test
	void test() {
		Adventure adventure = new Adventure("test.txt");
		
		String cmd = "go south";
		String expected = "Moving south...\r\n" + "You are at location 1,0";
		String actual = adventure.executeCommand(cmd);
		Assertions.assertEquals(expected, actual);
	}

}
