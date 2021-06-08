import java.util.*;

public class WeightedGraph<T> {
    private  boolean undirected;
    public ArrayList<VerPoint<T>> verPointArrayList = new ArrayList<>();
    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        verPointArrayList.add(new VerPoint<T>(v));
    }
    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
            if (!hasVertex(dest))
                addVertex(dest);
            if (hasEdge(source, dest)
                    || source.equals(dest))
                return; // reject parallels & self-loops
            if(!verPointArrayList.contains(new VerPoint<T>(source))){
                return;
            }
        } else {
            if (!hasVertex(dest))
                addVertex(dest);
            if (hasEdge(source, dest)
                    || source.equals(dest))
                return; // reject parallels & self-loops
            if(!verPointArrayList.contains(new VerPoint<T>(source))){
                return;
            }
        }

        verPointArrayList.get(verPointArrayList.indexOf(new VerPoint<T>(source))).plusVer(new VerPoint<T>(dest), weight);


        if (undirected)
            verPointArrayList.get(verPointArrayList.indexOf(new VerPoint<T>(dest))).plusVer(new VerPoint<T>(source), weight);
    }

    public int collectVerCount() {
        return verPointArrayList.size();
    }

    public int collectEdgesCount() {
        int count = verPointArrayList.stream().mapToInt(to -> to.getHashMap().size()).sum();

        if (undirected)

            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return verPointArrayList.contains(new VerPoint<T>(v));
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return verPointArrayList.get(verPointArrayList.indexOf(new VerPoint<T>(source))).getHashMap().containsKey(new VerPoint<T>(dest));
    }
}
