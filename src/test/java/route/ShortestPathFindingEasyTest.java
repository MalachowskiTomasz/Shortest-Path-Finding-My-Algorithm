package route;

import graph.AirportEdgeFactory;
import graph.DefaultEdge;
import graph.DirectedWeightGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by T4riS on 24.05.2017.
 */
public class ShortestPathFindingEasyTest {
    DirectedWeightGraph<Integer, DefaultEdge> graph;
    @Before
    public void setUp() throws Exception {
        graph = new DirectedWeightGraph<>(new AirportEdgeFactory<>(), true);
    }

    @Test
    public void test1() throws Exception{
        //Pre
        setUp();
        for(int i = 1; i <= 4; i++)
            graph.addVertex(i);

        graph.addEdge(1,2).setWeight(1);
        graph.addEdge(2,1).setWeight(1);
        graph.addEdge(2,4).setWeight(1);
        graph.addEdge(2,3).setWeight(3);
        graph.addEdge(3,4).setWeight(1);
        graph.addEdge(4,3).setWeight(1);

        //Act
        ShortestPathFinding<Integer, DefaultEdge> pathService = new ShortestPathFinding<>();
        Results resultDs = pathService.findShortestPath(graph, 1, 3);

        //Assert
        Assert.assertEquals(3, resultDs.getWeight(),0.01);
    }

    @Test
    public void test2() throws Exception{
        //Pre
        setUp();
        for(int i = 1; i <= 5; i++)
            graph.addVertex(i);

        graph.addEdge(1, 4).setWeight(5);
        graph.addEdge(2, 1).setWeight(10);
        graph.addEdge(4, 5).setWeight(2);
        graph.addEdge(4, 3).setWeight(2);
        graph.addEdge(5, 3).setWeight(3);
        graph.addEdge(2, 5).setWeight(1);
        graph.addEdge(5, 2).setWeight(1);
        graph.addEdge(3, 2).setWeight(1);

        //Act
        ShortestPathFinding<Integer, DefaultEdge> pathService = new ShortestPathFinding<>();
        Results resultDs = pathService.findShortestPath(graph, 1, 2);

        //Assert
        Assert.assertEquals(8, resultDs.getWeight(),0.01);
    }
}