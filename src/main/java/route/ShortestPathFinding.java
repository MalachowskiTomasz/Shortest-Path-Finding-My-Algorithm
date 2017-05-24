package route;

import graph.AbstractDirectedWeightGraphAdapter;
import graph.DefaultEdge;
import graph.DirectedWeightGraph;

import java.util.*;

/**
 * Created by Tomasz Malachowski on 24.05.2017.
 */
public class ShortestPathFinding<V, E> {
    private Map<V, Double> map;
    private Map<V, V> predecessors;
    private V TO;

    public Results<E> findShortestPath(DirectedWeightGraph<V,E> graph, V from, V to){
        map = new HashMap<>();
        predecessors = new HashMap<>();
        TO = to;
        for(V a : graph.vertexSet()) {
            map.put(a, Double.MAX_VALUE);
            predecessors.put(a, null);
        }
        map.replace(from, 0.0);
        queue.addAll(graph.outgoingEdgesOf(from));

        findShortestPath(graph);

        List<V> vertices = new ArrayList<>();
        for(V actual = to; actual != null; actual = predecessors.get(actual))
            vertices.add(actual);

        Collections.reverse(vertices);

        double weight = 0;
        List<E> path = new ArrayList<>();
        for(int i = 0; i < vertices.size()-1; i++){
            E edge = graph.getEdge(vertices.get(i), vertices.get(i+1));
            path.add(edge);
            weight += ((DefaultEdge)edge).getWeight();
        }

        Results resultDs = new Results();
        resultDs.setEdges(path);
        resultDs.setWeight(weight);

        return resultDs;
    }

    Queue<E> queue = new PriorityQueue<>((o1, o2) -> {
        return (int)(((DefaultEdge)o1).getWeight()-((DefaultEdge)o2).getWeight());
    });
    private void findShortestPath(AbstractDirectedWeightGraphAdapter graph){
        while(!queue.isEmpty()) {
            DefaultEdge edge = (DefaultEdge) queue.poll();
            if (map.get(edge.getSource()) + edge.getWeight() > map.get(TO))
                continue;

            if (map.get(edge.getSource()) + edge.getWeight() < map.get(edge.getTarget())) {
                map.put((V) edge.getTarget(), map.get(edge.getSource()) + edge.getWeight());
                predecessors.put((V) edge.getTarget(), (V) edge.getSource());
                queue.addAll(graph.outgoingEdgesOf(edge.getTarget()));
                if(queue.contains(graph.getEdge(edge.getTarget(), edge.getSource())))
                    queue.remove(graph.getEdge(edge.getTarget(), edge.getSource()));
            }
        }
    }
}
