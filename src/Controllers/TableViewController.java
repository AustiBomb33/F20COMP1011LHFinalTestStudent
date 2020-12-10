
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    private void top10Customers() {
        tableView.getSelectionModel().clearSelection();
        tableView.getItems().clear();
        tableView.getItems().addAll(JSONUtility.getCustomersFromJSON()
                .stream()
                .sorted(Comparator.comparing(Customer::getTotalPurchases, Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toList()));

        rowsInTableLabel.setText("" + tableView.getItems().size());
    }

    @FXML
    private void customersSavedOver5() {
        tableView.getSelectionModel().clearSelection();
        tableView.getItems().clear();
        tableView.getItems().addAll(JSONUtility.getCustomersFromJSON().stream().filter(Customer::savedLots).collect(Collectors.toList()));
        rowsInTableLabel.setText("" + tableView.getItems().size());
    }

    @FXML
    private void loadAllCustomers() {
        tableView.getSelectionModel().clearSelection();
        tableView.getItems().clear();
        tableView.getItems().addAll(JSONUtility.getCustomersFromJSON());
        rowsInTableLabel.setText("" + tableView.getItems().size());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableView();
        loadAllCustomers();

        tableView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            fillListView(tableView.getItems().get((int) newValue));
        });

        purchaseListView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if(purchaseListView.getItems().size() != 0){
                setImageView(purchaseListView.getItems().get((int)newValue).getImageURL());
                System.out.println(purchaseListView.getItems().get((int)newValue).getImageURL());
            }
        });
    }

    void initTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchasesString"));
    }

    void fillListView(Customer customer) {
        purchaseListView.getSelectionModel().select(0);
        imageView.setVisible(false);
        purchaseListView.getItems().clear();
        purchaseListView.getItems().addAll(customer.getPurchases());
        saleLabel.setText("Total Spent: " + customer.getTotalPurchasesString());
        msrpLabel.setText("Total Regular: " + customer.getTotalMSRPString());
        savingsLabel.setText("Total Saved: " + customer.getTotalSavingsString());
    }

    void setImageView(String imageURL){
        imageView.setVisible(true);
        Image img = new Image(imageURL);
        imageView.setImage(img);
    }

}
