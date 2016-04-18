import org.jgrapht.graph.DefaultEdge;

public class Link extends DefaultEdge {

	int weigth;
	Orientation orientation;

	public Link(Orientation orientation, int distance) {
		super();
		this.orientation = orientation;
		this.weigth = distance;
	}

	
}
