package graph;

import org.jgrapht.EdgeFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz Malachowski on 24.05.2017.
 */
public class DirectedWeightGraph<V, E> extends AbstractDirectedWeightGraphAdapter<V,E>{
    private List<Node> nodes = new ArrayList();
    public DirectedWeightGraph(EdgeFactory<V, E> edgeFactory, boolean isWeight) {
        super(edgeFactory, isWeight);
    }

    @Override
    public E getEdge(V v, V v1) {
        for(Node i : nodes){
            if(i.vertex.equals(v)){
                for(E a : i.edges){
                    DefaultEdge edge = (DefaultEdge)a;
                    if(edge.getTarget().equals(v1))
                        return a;
                }
            }
        }
        return null;
    }

    @Override
    public EdgeFactory<V, E> getEdgeFactory() {
        return edgeFactory;
    }

    @Override
    public E addEdge(V v, V v1) {
        if(v == null || v1 == null)
            throw new NullPointerException();
        if(!containsVertex(v) || !containsVertex(v1))
            throw new IllegalArgumentException();

        for(Node i : nodes){
            if(i.vertex.equals(v)){
                for(E a : i.edges){
                    DefaultEdge edge = (DefaultEdge)a;
                    if(edge.getTarget().equals(v1))
                        return a;
                }
                E temp = edgeFactory.createEdge(v, v1);
                i.edges.add(temp);
                return temp;
            }
        }
        return null;
    }

    @Override
    public boolean addVertex(V v) {
        if(v == null)
            throw new NullPointerException();
        for(Node i : nodes)
            if(i.vertex.equals(v))
                return false;
        nodes.add(new Node(v));
        return true;
    }

    @Override
    public boolean containsEdge(V v, V v1) {
        for(Node i : nodes) {
            if (i.vertex.equals(v)) {
                for (E a : i.edges) {
                    DefaultEdge edge = (DefaultEdge)a;
                    if(edge.getTarget().equals(v1))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsEdge(E e) {
        V source = (V)((DefaultEdge)e).getSource();
        for(Node i : nodes)
            if(i.vertex.equals(source))
                for(E a : i.edges)
                    if(a.equals(e))
                        return true;
        return false;
    }

    @Override
    public boolean containsVertex(V v) {
        for(Node i : nodes)
            if(i.vertex.equals(v))
                return true;
        return false;
    }

    @Override
    public Set<E> edgeSet() {
        Set<E> temp = new HashSet();
        for(Node i : nodes)
            temp.addAll(i.edges);
        return temp;
    }

    @Override
    public Set<E> edgesOf(V v) {
        if(v == null)
            throw new NullPointerException();
        if(!containsVertex(v))
            throw new IllegalArgumentException();
        for(Node i : nodes){
            if(i.vertex.equals(v))
                return i.edges;
        }
        return null;
    }

    @Override
    public E removeEdge(V v, V v1) {
        for(Node i : nodes){
            if(i.vertex.equals(v)) {
                for (E c : i.edges){
                    DefaultEdge edge = (DefaultEdge)c;
                    if(edge.getTarget().equals(v1)) {
                        i.edges.remove(c);
                        return c;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean removeEdge(E e) {
        V v = (V)((DefaultEdge)e).getSource();
        for(Node i : nodes)
            if(i.vertex.equals(v))
                for (E c : i.edges)
                    if(c.equals(e))
                        return i.edges.remove(c);
        return false;
    }

    @Override
    public boolean removeVertex(V v) {
        for(Node i : nodes) {
            if (i.vertex.equals(v)) {
                nodes.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<V> vertexSet() {
        Set<V> temp = new HashSet();
        for(Node i : nodes)
            temp.add(i.vertex);
        return temp;
    }

    @Override
    public V getEdgeSource(E e) {
        return (V)((DefaultEdge)e).getSource();
    }

    @Override
    public V getEdgeTarget(E e) {
        return (V)((DefaultEdge)e).getTarget();
    }

    @Override
    public double getEdgeWeight(E e) {
        return ((DefaultEdge)e).getWeight();
    }

    @Override
    public void setEdgeWeight(E e, double v) {
        ((DefaultEdge)e).setWeight(v);
    }

    @Override
    public int inDegreeOf(V v) {
        int j = 0;
        for(Node i : nodes){
            for(E a : i.edges){
                DefaultEdge edge = (DefaultEdge)a;
                if(edge.getTarget().equals(v))
                    j++;
            }
        }
        return j;
    }

    @Override
    public Set<E> incomingEdgesOf(V v) {
        Set<E> temp = new HashSet();
        for(Node i : nodes){
            for(E a : i.edges){
                DefaultEdge edge = (DefaultEdge)a;
                if(edge.getTarget().equals(v))
                    temp.add(a);
            }
        }
        return temp;
    }

    @Override
    public int outDegreeOf(V v) {
        for(Node i : nodes)
            if(i.vertex.equals(v))
                return i.edges.size();
        return 0;
    }

    @Override
    public Set<E> outgoingEdgesOf(V v) {
        for(Node i : nodes)
            if(i.vertex.equals(v))
                return i.edges;
        return null;
    }

    private Node found;
    private void findKeyBinary(V key, int start, int end){
        found = null;
        int mid = (start+end)/2;
        if(start <= end) {
            if (key.toString().compareTo(nodes.get(mid).toString()) > 0)
                findKeyBinary(key, start, mid - 1);
            else if (key.toString().compareTo(nodes.get(mid).toString()) < 0)
                findKeyBinary(key, mid + 1, end);
            else
                found = nodes.get(mid);
        }
    }

    private class Node{
        public V vertex;
        public Set<E> edges = new HashSet();

        public Node(V vertex) {
            this.vertex = vertex;
        }
    }
}
