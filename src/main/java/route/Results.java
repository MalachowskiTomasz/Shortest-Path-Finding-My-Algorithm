package route;

import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz Malachowski on 24.05.2017.
 */
public class Results<E> {
    private List<E> edges;
    private double weight;

    public List<E> getEdges(){
        return edges;
    }
    public void setEdges(List<E> edges){
        this.edges = edges;
    }

    public double getWeight(){
        return weight;
    }
    public void setWeight(double value){
        this.weight = value;
    }
}
