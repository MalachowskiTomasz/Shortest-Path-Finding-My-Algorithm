package graph;

import org.jgrapht.DirectedGraph;
import org.jgrapht.EdgeFactory;
import org.jgrapht.WeightedGraph;

import java.util.Collection;
import java.util.Set;

/**
 * Do not modify this class if it is not necessary.
 * Please see http://jgrapht.org/javadoc/org/jgrapht/DirectedGraph.html
 */
public abstract class AbstractDirectedWeightGraphAdapter<V,E> implements DirectedGraph<V,E>, WeightedGraph<V,E> {
    protected EdgeFactory<V,E> edgeFactory;
    protected boolean isWeight;
    protected static final int DEFAULT_WEIGHT=1;

    public AbstractDirectedWeightGraphAdapter(EdgeFactory<V,E> edgeFactory, boolean isWeight) {
       this.edgeFactory=edgeFactory;
       this.isWeight=isWeight;
    }


    @Override
    public Set<E> getAllEdges(V v, V v1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract E getEdge(V v, V v1);

    @Override
    public abstract EdgeFactory<V, E> getEdgeFactory();

    @Override
    public abstract E addEdge(V v, V v1);

    @Override
    public boolean addEdge(V v, V v1, E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract boolean addVertex(V v);

    @Override
    public abstract boolean containsEdge(V v, V v1);

    @Override
    public abstract boolean containsEdge(E e);

    @Override
    public abstract boolean containsVertex(V v);

    @Override
    public abstract Set<E> edgeSet();

    @Override
    public abstract Set<E> edgesOf(V v);

    @Override
    public boolean removeAllEdges(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<E> removeAllEdges(V v, V v1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAllVertices(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract E removeEdge(V v, V v1);

    @Override
    public abstract boolean removeEdge(E e);

    @Override
    public abstract boolean removeVertex(V v);

    @Override
    public abstract Set<V> vertexSet();

    @Override
    public abstract V getEdgeSource(E e);

    @Override
    public abstract V getEdgeTarget(E e);

    @Override
    public abstract double getEdgeWeight(E e);

    @Override
    public abstract void setEdgeWeight(E e, double v);

    @Override
    public abstract int inDegreeOf(V v);

    @Override
    public abstract Set<E> incomingEdgesOf(V v);

    @Override
    public abstract int outDegreeOf(V v);

    @Override
    public abstract Set<E> outgoingEdgesOf(V v);
}
