# My Algorithm

This algorithm connects advantages of Prim Algorithm and Dijkstra Algorithm to find the shortest path in the graph

Step-by-step solution:

```
1. Create a map with distances to all vertices and initialize it with maximum distance
2. Set the distance of vertex FROM to 0
3. Create a priority queue of edges
4. To the queue add all outgoing edges of vertex FROM
5. While queue is not empty:
  5a. Get edge from queue   
  5b. If distance(edge.FROM) + edge.weight < distance(TO) continue
  5c. If distance(edge.FROM) + edge.weight < distance(edge.TO)
    5ca. distance(edge.TO) := distance(edge.FROM) + edge.weight
    5cb. Add all outgoing edges of vertex edge.TO to queue
```
