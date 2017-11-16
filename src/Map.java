import java.util.ArrayList;

public class Map {
	private int rows;
	private int columns;
	ArrayList<String> mapRows;
	char[][] map;
	
	public Map(String[] mapSize, ArrayList<String> mapTerrains) {
		rows = Integer.parseInt(mapSize[0]);
		columns = Integer.parseInt(mapSize[1]);
		mapRows = mapTerrains;
		map = new char[rows][columns];
		
		// Fill in map.
		int row = 0;
	    for (String line : mapRows) {
	       char[] terrains = line.toCharArray();
	       for(int i = 0; i < terrains.length; i++ ) {
	    	   map[row][i] = terrains[i];
	       }
	       row++;
	    }
	}
	
	public char getTerrain(int x, int y) {
		if (x < 0 || x >= columns || y < 0 || y >= rows) {
			return 'X';
		}
		
		return map[y][x];
	}
	
	public void surroundingTerrain(int x, int y, int vis) {
		for (int dy = -vis; dy <= vis; dy++) {
			for (int dx = -vis; dx <= vis; dx++) {
				System.out.printf("%s", getTerrain(x+dx,y+dy));
			}
			
			System.out.println();
		}
		
		//System.out.printf("%s%s%s\n", getTerrain(x1,y1), getTerrain(x1,y2), getTerrain(x1,y3));
    	//System.out.printf("%s%s%s\n", getTerrain(x2,y1), getTerrain(x2,y2), getTerrain(x2,y3));
    	//System.out.printf("%s%s%s\n", getTerrain(x3,y1), getTerrain(x3,y2), getTerrain(x3,y3));
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
}
