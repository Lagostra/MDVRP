package info.andreassen.mdvrp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    Customer[] customers;
    Depot[] depots;

    public Main() {

    }

    public void loadProblem(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader((path)))) {
            // Read initial data
            String[] firstLine = reader.readLine().split(" ");
            int maxVehicles = Integer.parseInt(firstLine[0]);
            int numCustomers = Integer.parseInt(firstLine[1]);
            int numDepots = Integer.parseInt(firstLine[2]);

            depots = new Depot[numDepots];
            customers = new Customer[numCustomers];

            // Get capacities for all depots
            for (int i = 0; i < numDepots; i++) {
                String[] depotLine = reader.readLine().strip().split("\\s+");
                int maxDuration = Integer.parseInt(depotLine[0]);
                int maxLoad = Integer.parseInt(depotLine[1]);
                depots[i] = new Depot(maxVehicles, maxDuration, maxLoad);
            }

            // Get data for all customers
            for (int i = 0; i < numCustomers; i++) {
                String[] customerLine = reader.readLine().strip().split("\\s+");
                int x = Integer.parseInt(customerLine[1]);
                int y = Integer.parseInt(customerLine[2]);
                int serviceDuration = Integer.parseInt(customerLine[3]);
                int demand = Integer.parseInt(customerLine[4]);

                customers[i] = new Customer(x, y, serviceDuration, demand);
            }

            // Get positions of depots
            for (int i = 0; i < numDepots; i++) {
                String[] depotLine = reader.readLine().strip().split("\\s+");
                int x = Integer.parseInt(depotLine[1]);
                int y = Integer.parseInt(depotLine[2]);
                depots[i].x = x;
                depots[i].y = y;
            }

            System.out.println("Load finished");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String... args) {
        Main main = new Main();
        main.loadProblem("data/p01");
    }
}
