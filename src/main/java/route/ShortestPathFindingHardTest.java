package route;

import database.DataLoaderImpl;
import database.InmemmoryDataBase;
import entity.Airport;
import entity.Route;
import graph.AirportEdgeFactory;
import graph.DefaultEdge;
import graph.DirectedWeightGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by T4riS on 24.05.2017.
 */
public class ShortestPathFindingHardTest {
    final static String PATH = System.getProperty("user.dir") + "\\resources\\";
    InmemmoryDataBase dataBase;
    DirectedWeightGraph<Airport, DefaultEdge> graphAdapter;

    private static String FROM = "WAW";
    private static String TO = "JFK";

    @Before
    public void setUp() throws Exception {
        System.out.print("Loading database...");
        DataLoaderImpl dataLoader = new DataLoaderImpl();
        dataLoader.loadAllData(PATH + "airports.dat", PATH + "airlines.dat", PATH + "routes.dat");
        dataBase = InmemmoryDataBase.getInstance();
        graphAdapter = new DirectedWeightGraph<>(new AirportEdgeFactory<>(), true);
        for(Airport e : dataBase.getAirports())
            if(e != null)
                graphAdapter.addVertex(e);
        for(Route e : dataBase.getRoutes()) {
            if(e != null) {
                double weight = Math.sqrt(Math.pow(e.getOrigin().getLongitude() - e.getDestination().getLongitude(), 2) + Math.pow(e.getOrigin().getLatitude() - e.getDestination().getLatitude(), 2));
                graphAdapter.addEdge(e.getOrigin(), e.getDestination()).setWeight(weight);
            }
        }
        System.out.println("Done.");
    }

    @Test
    public void searchShortestPathUsingDijkstraAlg() throws Exception {
        //Pre
        //setUp();
        Airport from = null;
        Airport to = null;

        for(Airport a : dataBase.getAirports()){
            if(a.getIataCode().equals(FROM)){
                from = a;
                if(to != null)
                    break;
            }
            if(a.getIataCode().equals(TO)){
                to = a;
                if(from != null)
                    break;
            }
        }

        //Act
        System.out.print("Searching connection between " + FROM  + " to " + TO + "..." );
        long time = System.currentTimeMillis();
        ShortestPathFinding<Airport, DefaultEdge> shortestPathService = new ShortestPathFinding<>();
        Results<DefaultEdge> resultDs = shortestPathService.findShortestPath(graphAdapter, from, to);
        System.out.println("Found");
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - time) + " ms");
        System.out.println("Distance: " + resultDs.getWeight()*40075/360 + " km");

        for(DefaultEdge e : resultDs.getEdges()){
            Airport source = (Airport)e.getSource();
            Airport destination = (Airport)e.getTarget();
            System.out.println("("+ source.getIataCode() +")" +  source.getName() + "\n" +
                    "\t -> " + "("+ destination.getIataCode() +")" + destination.getName());
        }
    }

}