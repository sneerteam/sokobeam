package sneer.game.sokabota.core;

import java.util.HashSet;
import java.util.Set;

import sneer.gameengine.grid.Direction;
import sneer.gameengine.grid.Thing;

public class Gun extends Thing {

	private Set<BeamSegment> beam;

	Gun(Direction dir) {
		direction = dir;
	}
	
	@Override
	public String toString() {
		return ">";
	}

	public void toggle() {
		if (beam == null) {
			beam = new HashSet<BeamSegment>();
			new BeamSegment(square.neighbor(direction), direction, beam);
		} else {
			for (BeamSegment seg : beam)
				seg.disappear();
			beam = null;
		}
	}

}
