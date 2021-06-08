import java.util.*;
public class VerPoint<V>{
    private V giv;
    private Map<VerPoint<V>, Double> hashMap = new HashMap<>();

    public VerPoint(V giv) {
        this.giv = giv;
    }

    public void plusVer(VerPoint<V> vVerPoint, double weight){
        hashMap.put(vVerPoint, weight);
    }

    public Map<VerPoint<V>, Double> getHashMap() {
        return hashMap;
    }

    public V getGiv() {
        return giv;
    }
}
