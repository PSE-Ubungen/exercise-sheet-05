package de.unistuttgart.iste.sqa.pse.sheet05.homework;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * In this hamster-game {@code paule} gets four new friends.
 *
 * @author (Your name)
 * @version (A date or a version number)
 */
public class HamsterPartyGame extends SimpleHamsterGame {

	/**
	 * Constructor for the Party Game.
	 */
	public HamsterPartyGame() {
		this.loadTerritoryFromResourceFile("/territories/territory-hamsterparty.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}
	
	/**
	 * Starts the HamsterPartyGame.	
	 * 
	 */
	protected void run() {

		Territory partyTerritory = game.getTerritory();

		Hamster adam = new Hamster(partyTerritory, new Location(5, 3), Direction.NORTH, 10);
		Hamster eve = new Hamster(partyTerritory, new Location(3, 6), Direction.WEST, 10);

		Hamster erik = new Hamster(partyTerritory, new Location(2, 3), Direction.SOUTH, 10);
		Hamster lupin = new Hamster(partyTerritory, new Location(3, 4), Direction.WEST, 10);

		adam.write("Party!");
		eve.write("Party!");
		erik.write("Party!");
		lupin.write("Party!");
	}
}
