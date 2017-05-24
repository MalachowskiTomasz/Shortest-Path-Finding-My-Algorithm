package database;

import entity.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoaderImpl implements DataLoader {
    @Override
    public void loadAirports(String pathToFile) {
         /* (TODO Lab No. 1) Please introduce a sensible implementation */
         try {
             FileReader fr = new FileReader(pathToFile);
             BufferedReader br = new BufferedReader(fr);

             List temp = new ArrayList();

             String line;
             while((line = br.readLine()) != null){
                 if(line.startsWith("#")) continue;
                 String[] split = line.split("\t");
                 temp.add(new Airport(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2]), split[3]));
             }
             InmemmoryDataBase.getInstance().setAirports(temp);
             br.close();
         }catch(Exception e){
             System.out.println(e);
         }
    }

    @Override
    public void loadAirline(String pathToFile) {
         /* (TODO Lab No. 1) Please introduce a sensible implementation */
        try {
            FileReader fr = new FileReader(pathToFile);
            BufferedReader br = new BufferedReader(fr);

            List temp = new ArrayList();

            String line;
            while((line = br.readLine()) != null){
                if(line.startsWith("#")) continue;
                String[] split = line.split("\t");
                temp.add(new Airline(split[0], split[1]));
            }
            InmemmoryDataBase.getInstance().setAirlines(temp);
            br.close();
        }catch(java.io.IOException e){
            System.out.println("Couldn't load " + pathToFile);
        }
    }

    @Override
    public void loadRoute(String pathToFile) {
         /* (TODO Lab No. 1) Please introduce a sensible implementation */

        if(InmemmoryDataBase.getInstance().getAirports() == null || InmemmoryDataBase.getInstance().getAirlines() == null) {
            System.out.println("Nie mozna bylo zaladowac");
            return;
        }
        try {
            FileReader fr = new FileReader(pathToFile);
            BufferedReader br = new BufferedReader(fr);
            List temp = new ArrayList<Route>();

            String line;
            while((line = br.readLine()) != null){
                if(line.startsWith("#")) continue;
                String[] split = line.split("\t");

                Airport fromAirport = null;
                Airport toAirport = null;
                Airline airline = null;

                for(Airline a : InmemmoryDataBase.getInstance().getAirlines()) {
                    if (a.getCode().equals(split[0])) {
                        airline = a;
                        break;
                    }
                }
                for(Airport a : InmemmoryDataBase.getInstance().getAirports()) {
                    if (a.getIataCode().equals(split[1])) {
                        fromAirport = a;
                        break;
                    }
                }
                for(Airport a : InmemmoryDataBase.getInstance().getAirports()) {
                    if (a.getIataCode().equals(split[2])) {
                        toAirport = a;
                        break;
                    }
                }
                Route x = new Route(airline, fromAirport, toAirport);
                if(x == null)
                    System.out.println("Problem!");
                temp.add(x);
            }
            InmemmoryDataBase.getInstance().setRoutes(temp);
            br.close();
        }catch(java.io.IOException e){
            System.out.println("Couldn't load " + pathToFile);
        }
    }

    @Override
    public void loadAllData(String pathToAirportsFile, String pathToAirlinesFile, String pathToRoutesFile) {
        loadAirports(pathToAirportsFile);
        loadAirline(pathToAirlinesFile);
        loadRoute(pathToRoutesFile);
    }
}
