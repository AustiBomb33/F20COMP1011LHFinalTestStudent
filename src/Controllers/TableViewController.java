
//Austin Marcoux
//1099028



package Controllers;

import Models.Customer;
import Models.Product;
import Utility.JSONUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {
    @FXML
    private Label saleLabel;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;

    @FXML
    private void top10Customers()
    {
        System.out.println("called method top10Customers()");
    }

    @FXML
    private void customersSavedOver5()
    {
        System.out.println("called method customersSavedOver5()");
    }

    @FXML
    private void loadAllCustomers()
    {
        System.out.println("called method loadAllCustomers");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchasesString"));
        tableView.getItems().addAll(JSONUtility.getCustomersFromJSON());
    }
}
