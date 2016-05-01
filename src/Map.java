
import java.util.ArrayList;

/**
 * Created by George, Haris and Hronis on 11-Apr-16.
 */
public class Map {

    // static problem solution
    private ArrayList<Nest> arrayMap = new ArrayList();

    private double distanceMax;

    private int x;
    private int y;

    public Map() {
        fill();
        distanceMax = 141.42;
    }

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Nest> getArrayMap() {
        return arrayMap;
    }

    public double getDistaneMax() {
        return distanceMax;
    }

    public Nest getNest(int index){
        return arrayMap.get(index);
    }
    private void fill() {
        arrayMap.add(new Nest(25, 65, 100));
        arrayMap.add(new Nest(23, 8, 200));
        arrayMap.add(new Nest(7, 13, 327));
        arrayMap.add(new Nest(95, 53, 440));
        arrayMap.add(new Nest(3, 3, 450));
        arrayMap.add(new Nest(54, 56, 639));
        arrayMap.add(new Nest(67, 78, 650));
        arrayMap.add(new Nest(32, 4, 678));
        arrayMap.add(new Nest(24, 76, 750));
        arrayMap.add(new Nest(66, 89, 801));
        arrayMap.add(new Nest(84, 4, 945));
        arrayMap.add(new Nest(34, 23, 967));

    }
}// end map
