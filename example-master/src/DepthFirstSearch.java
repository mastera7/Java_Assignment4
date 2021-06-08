

public class DepthFirstSearch<T> extends Search<T> {

    public DepthFirstSearch(WeightedGraph<T> graph, T source) {
        super(new VerPoint<T>(source));
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<T> graph, T current) {
        set.add(new VerPoint<T>(current));
        counting++;

        VerPoint<T> cur = new VerPoint<T>(current);
        for(Map.Entry<VerPoint<T>, Double> entry : graph.verPointArrayList.get(graph.verPointArrayList.indexOf(cur)).getHashMap().entrySet()){
            VerPoint<T> verPoint = entry.getKey();
            if (!set.contains(verPoint)) {
                pointMap.put(verPoint, new VerPoint<T>(current));
                dfs(graph, verPoint.getGiv());
            }
        }
    }

}
