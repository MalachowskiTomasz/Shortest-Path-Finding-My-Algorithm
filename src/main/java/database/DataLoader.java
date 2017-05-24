package database;

/**
 * Do not modify this class if it is not necessary.
 */
public interface DataLoader {
    public void loadAirports(String pathToFile);

    public void loadAirline(String pathToFile);

    public void loadRoute(String pathToFile);

    public void loadAllData(String pathToAirportsFile, String pathToAirlinesFile, String pathToRoutesFile);
}
