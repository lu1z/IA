
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.SimpleGraph;

public class Snapshot extends SimpleGraph<Tile, Link> {

	public Snapshot(EdgeFactory<Tile, Link> ef) {
		super(ef);
	}

	public Snapshot(Class<? extends Link> edgeClass) {
		super(edgeClass);
	}

	public List<Link> getEdgesWith(Tile evaluating, Orientation orientation) {
		List edgesWith = new ArrayList<Link>();
		for (Link edge : this.edgesOf(evaluating)) {
			if (edge.orientation == null || orientation.equals(edge.orientation))
				edgesWith.add(edge);
		}
		return edgesWith;
	}

}
