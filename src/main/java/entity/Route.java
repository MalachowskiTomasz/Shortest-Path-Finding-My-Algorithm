package entity;

/**
 * Class represents a single route.
 * Do not modify this class if it is not necessary.
 * This file reflects the structure of the data in file routes.dat.
 */
public class Route {
    private Airline airline;
    private Airport origin;
    private Airport destination;

    public Route() {
    }

    public Route(Airline airline, Airport origin, Airport destination) {
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Route{" +
                "airline=" + airline +
                ", origin=" + origin +
                ", destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (!getAirline().equals(route.getAirline())) return false;
        if (!getOrigin().equals(route.getOrigin())) return false;
        return getDestination().equals(route.getDestination());
    }

    @Override
    public int hashCode() {
        int result = getAirline().hashCode();
        result = 31 * result + getOrigin().hashCode();
        result = 31 * result + getDestination().hashCode();
        return result;
    }
}
