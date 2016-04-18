
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.*;
import org.jgrapht.graph.*;
public class SnapShoot extends SimpleGraph<Tile, Link> {

	public SnapShoot(EdgeFactory<Tile, Link> ef) {
		super(ef);
		// TODO Auto-generated constructor stub
	}

	public SnapShoot(Class<? extends Link> edgeClass) {
		super(edgeClass);
		// TODO Auto-generated constructor stub
	}
	
	public List<Link> getEdgesWith(Orientation orientation) {
		List edgesWith = new ArrayList<Link>();
		for(Link edge : this.edgeSet()) {
			if(edge.orientation.equals(orientation))
				edgesWith.add(edge);
		}
		return edgesWith;
	}

}
