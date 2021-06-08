import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(WeightedGraph<T> tWeightedG, T gSource) {
        super(new VerPoint<T>(gSource));
        bfs(tWeightedG, gSource);
    }

    private void bfs(WeightedGraph<T> tWeightedG, T tCur) {
        set.add(new VerPoint<T>(tCur));
        Queue<VerPoint<T>> verPointQueue = new LinkedList<>();
        verPointQueue.add(new VerPoint<T>(tCur));
        while (!verPointQueue.isEmpty()) {
            VerPoint<T> v = verPointQueue.remove();
            for (Iterator<Map.Entry<VerPoint<T>, Double>> iterator = tWeightedG.verPointArrayList.get(tWeightedG.verPointArrayList.indexOf(v)).getHashMap().entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<VerPoint<T>, Double> entry = iterator.next();
                VerPoint<T> verPoint = entry.getKey();
                if (!set.contains(verPoint)) {
                    set.add(verPoint);
                    pointMap.put(verPoint, v);
                    verPointQueue.add(verPoint);
                }
            }
        }
    }
}

