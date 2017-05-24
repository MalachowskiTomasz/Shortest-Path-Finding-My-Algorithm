package entity;

/**
 * Class represents a single airline.
 * Do not modify this class if it is not necessary.
 * This file reflects the structure of the data in file airlines.dat.
 */
public class Airline {
    private String code;
    private String name;

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Airline() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        return getCode().equals(airline.getCode());
    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }
}
