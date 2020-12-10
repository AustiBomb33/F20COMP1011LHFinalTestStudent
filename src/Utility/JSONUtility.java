
//Austin Marcoux
//1099028

package Utility;

import Models.Customer;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONUtility {

    public static ArrayList<Customer> getCustomersFromJSON() {

        ArrayList<Customer> customers = new ArrayList<>();
        Gson gson = new Gson();
        try (
                FileReader fileReader = new FileReader("./src/customers.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
            Customer[] customersFromJSON = gson.fromJson(jsonReader, Customer[].class);
            Arrays.asList(customersFromJSON).forEach(customer -> {
                customers.add(customer);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;

    }

}
