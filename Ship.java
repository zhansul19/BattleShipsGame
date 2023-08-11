package BattleShipsGame;

import java.util.ArrayList;

public class Ship {
	ArrayList<String> locationCells;
	String name;
	// int[] locationCells;
	// int numOfHits = 0;

	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}

	public String checkYourself(String guess) {
		String result = "miss";

		int index = locationCells.indexOf(guess);

		if (index >= 0) {
			locationCells.remove(guess);
			if (locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}
		return result;
	}

	public void setName(String nameChange) {
		name = nameChange;
	}
}