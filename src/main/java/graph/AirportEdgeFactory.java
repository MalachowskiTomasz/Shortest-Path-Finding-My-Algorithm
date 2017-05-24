package graph;

import org.jgrapht.EdgeFactory;


public class AirportEdgeFactory<V,E> implements EdgeFactory<V,E> {
    @Override
    public E createEdge(V v, V v1) {
        DefaultEdge defaultEdge = new DefaultEdge();
        defaultEdge.setSource(v);
        defaultEdge.setTarget(v1);
        return (E)defaultEdge;
    }
}
