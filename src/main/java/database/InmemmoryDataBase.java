package database;

import entity.*;
import java.util.List;

/**
 * Class represents a simple in-memmory database.
 * Do not modify this class if it is not necessary.
 */
public class InmemmoryDataBase {
    private static InmemmoryDataBase self;
    private List<Airport> airports;
    private List<Airline> airlines;
    private List<Route> routes;

    /* must be private */
    private InmemmoryDataBase() {
    }

    /* singleton pattern */
    public static InmemmoryDataBase getInstance() {
        if (self == null) {
            self = new InmemmoryDataBase();
        }
        return self;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void appendRoutes(Route route) {
        this.routes.add(route);
    }

    public void appendAirport(Airport airport) {
        this.airports.add(airport);
    }

    public void appendAirline(Airline airline) {
        this.airlines.add(airline);
    }
}
