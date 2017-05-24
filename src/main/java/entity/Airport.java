package entity;

/**
 * Class represents a single airport.
 * Do not modify this class if it is not necessary.
 * This file reflects the structure of the data in file airports.dat.
 */
public class Airport {
    private String iataCode;
    private double latitude;
    private double longitude;
    private String name;

    public Airport(String iataCode, double latitude, double longitude, String name) {
        this.iataCode = iataCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public Airport() {
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "iataCode='" + iataCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return getIataCode().equals(airport.getIataCode());
    }

    @Override
    public int hashCode() {
        return getIataCode().hashCode();
    }
}
