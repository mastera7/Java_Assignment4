import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private Set<T> unsettledNodes;
    private Map<T, Double> distances;
    private WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            T node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);
            for (T target : graph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node)
                        + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node)
                            + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}


