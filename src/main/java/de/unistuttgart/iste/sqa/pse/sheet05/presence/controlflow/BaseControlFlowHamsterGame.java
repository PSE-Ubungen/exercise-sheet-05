package de.unistuttgart.iste.sqa.pse.sheet05.presence.controlflow;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A new HamsterGame to try out some control flow structures.
 *
 * @author (your name)
 * @version (version number or date)
 */
public abstract class BaseControlFlowHamsterGame extends SimpleHamsterGame {

	/**
	 * Constructor for the BaseControlFlowHamsterGame class.
	 * Do not modify!
	 *
	 * @param territoryFile file-path to the .ter file specifying the game territory
	 */
	public BaseControlFlowHamsterGame(final String territoryFile) {
		this.loadTerritoryFromResourceFile(territoryFile);
		this.displayInNewGameWindow();
		game.startGame();
	}

	
	/*@
	 @ ensures that paule stands in front of a wall.
	 @*/
	/**
	 * Move paule to the next wall.
	 * 
	 * This is an example for an operation with with pre- and postconditions and
	 * loop(in)variants in natural language.
	 */
	protected void moveToWall() {
		/*@
		 @ loop_invariant paule moved number of already executed loop iterations steps.
		 @ decreasing number of tiles between paule and the next wall.
		 @*/
		while(paule.frontIsClear()) {
			paule.move();
		}
	}
	
	/*
	 * Please implement your solutions into the following methods.
	 * Remember to add the appropriate JavaDoc documentation and pre-post conditions for each operation
	 * as well as the variants and loop invariants for any loops that are part of your implementation.
	 */
	
	
	protected void pickGrainIfAvailable() {
		if(paule.grainAvailable()){
			paule.pickGrain();
		}
	}

	protected void pickAllGrains() {
		while (paule.grainAvailable()) {
			paule.pickGrain();
		}
	}

	protected void multiMove(Integer times) {
		for (int index = 0; index < times; index++) {
			paule.move();
		}
	}

	protected void pickGrainOrMove() {
		if (paule.grainAvailable()) {
			paule.pickGrain();
		}
		else{
			paule.move();
		}
	}

	protected void pickAllGrainsOnNonEmptyTile() {
		do {
			paule.pickGrain();
		} while (paule.grainAvailable());
	}

	protected void putGrains(Integer amountOfGrains) {
		for (int index = 0; index < amountOfGrains; index++) {
			paule.putGrain();
		}
	}

	protected void emptyMouth() {
		while (!paule.mouthEmpty()) {
			paule.putGrain();
		}
	}

	protected void cleanTerritory() {
		boolean done = false;
		while (!done) {
			while (paule.frontIsClear()) {
				pickGrainOrMove();
				if (!paule.frontIsClear() && paule.getDirection() == Direction.EAST) {
					paule.turnLeft();
					paule.turnLeft();
					paule.turnLeft();
					if (!paule.frontIsClear()) {
						done = true;
					}
					else{
						pickAllGrains();
						paule.move();
						paule.turnLeft();
						paule.turnLeft();
						paule.turnLeft();
					}
				}
				else if(!paule.frontIsClear() && paule.getDirection() == Direction.WEST){
					paule.turnLeft();
					if (!paule.frontIsClear()) {
						done = true;
					}
					else{
						pickAllGrains();
						paule.move();
						paule.turnLeft();
					}
				}
			}
		}
	}
}
