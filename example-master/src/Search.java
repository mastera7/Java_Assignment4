import java.util.*;

public class Search<T> {
    protected int counting;
    protected Set<VerPoint<T>> set;
    protected Map<VerPoint<T>, VerPoint<T>> pointMap;
    protected final VerPoint<T> point;

    public Search(VerPoint<T> point) {
        this.point = point;
        set = new HashSet<>();
        pointMap = new HashMap<>();
    }

    public boolean PathBool(VerPoint<T> v) {
        return set.contains(v);
    }

    public Iterable<VerPoint<T>> pathTo(T v) {
        if (!PathBool(new VerPoint<T>(v))) return null;
        LinkedList<VerPoint<T>> ls = new LinkedList<>();
        for (VerPoint<T> i = new VerPoint<T>(v); i != point; i = pointMap.get(i)) {
            ls.push(i);
        }
        ls.push(point);

        return ls;
    }

}
