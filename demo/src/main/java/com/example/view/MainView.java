package com.example.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.model.BasketItem;
import com.example.model.Order;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainView {
    private GridPane menuGrid;
    private TableView<BasketItem> basketTable;
    private Button placeOrderButton;

    public void start(Stage primaryStage, ObservableList<BasketItem> basketItems) {
        menuGrid = new GridPane();
        menuGrid.setHgap(10);
        menuGrid.setVgap(10);

        // Basket
        basketTable = new TableView<>();
        basketTable.setItems(basketItems);

        TableColumn<BasketItem, String> itemColumn = new TableColumn<>("Item");
        itemColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));

        TableColumn<BasketItem, Integer> quantityColumn = new TableColumn<>("Qty");
        quantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()).asObject());

        TableColumn<BasketItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()).asObject());

        basketTable.getColumns().addAll(itemColumn, quantityColumn, priceColumn);

        placeOrderButton = new Button("Place Order");

        VBox basketBox = new VBox(10, basketTable, placeOrderButton);

        HBox mainLayout = new HBox(20, menuGrid, basketBox);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setTitle("Burrito King Restaurant");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane getMenuGrid() {
        return menuGrid;
    }

    public TableView<BasketItem> getBasketTable() {
        return basketTable;
    }

    public Button getPlaceOrderButton() {
        return placeOrderButton;
    }

    public void addMenuItemToGrid(com.example.model.MenuItem burritos, int rowIndex, Runnable addItemAction) {
        ImageView imageView = new ImageView(new Image(burritos.getImagePath()));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label nameLabel = new Label(burritos.getName());
        Label priceLabel = new Label(String.format("Price: $%.2f", burritos.getPrice()));

        Spinner<Integer> quantitySpinner = new Spinner<>(1, 20, 1);
        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> addItemAction.run());

        VBox itemBox = new VBox(5, imageView, nameLabel, priceLabel, quantitySpinner, addButton);
        menuGrid.add(itemBox, 0, rowIndex);
    }
        public void showOrderSummary(double totalPrice, int waitingTime, Runnable onConfirm) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Order Summary");

        Label totalLabel = new Label("Total Price: $" + totalPrice);
        Label waitingLabel = new Label("Estimated Waiting Time: " + waitingTime + " minutes");

        Button confirmButton = new Button("Confirm Order");
        confirmButton.setOnAction(e -> {
            onConfirm.run();
            dialog.close();
        });

        VBox dialogVBox = new VBox(10, totalLabel, waitingLabel, confirmButton);
        Scene dialogScene = new Scene(dialogVBox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public void showPaymentForm(Runnable onPaymentSuccess) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Payment Information");

        TextField cardNumberField = new TextField();
        cardNumberField.setPromptText("Card Number (16 digits)");

        DatePicker expiryDatePicker = new DatePicker();
        expiryDatePicker.setPromptText("Expiry Date");

        TextField cvvField = new TextField();
        cvvField.setPromptText("CVV (3 digits)");

        Button payButton = new Button("Pay Now");
        payButton.setOnAction(e -> {
            String cardNumber = cardNumberField.getText();
            LocalDate expiryDate = expiryDatePicker.getValue();
            String cvv = cvvField.getText();

            if (validatePaymentDetails(cardNumber, expiryDate, cvv)) {
                onPaymentSuccess.run();
                dialog.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid payment details. Please check and try again.");
                alert.show();
            }
        });

        VBox dialogVBox = new VBox(10, cardNumberField, expiryDatePicker, cvvField, payButton);
        Scene dialogScene = new Scene(dialogVBox, 300, 250);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    private boolean validatePaymentDetails(String cardNumber, LocalDate expiryDate, String cvv) {
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d{16}")) {
            return false;
        }
        if (expiryDate.isBefore(LocalDate.now())) {
            return false;
        }
        if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
            return false;
        }
        return true;
    }
     public void showAllOrders(ObservableList<Order> orders) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("All Orders");

        TableView<Order> ordersTable = new TableView<>();
        ordersTable.setItems(orders);

        TableColumn<Order, String> orderNumberColumn = new TableColumn<>("Order Number");
        orderNumberColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOrderNumber()));

        TableColumn<Order, String> orderTimeColumn = new TableColumn<>("Order Time");
        orderTimeColumn.setCellValueFactory(data -> new SimpleStringProperty(
                data.getValue().getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

        TableColumn<Order, Double> totalPriceColumn = new TableColumn<>("Total Price");
        totalPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotalPrice()).asObject());

        TableColumn<Order, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        ordersTable.getColumns().addAll(orderNumberColumn, orderTimeColumn, totalPriceColumn, statusColumn);

        VBox dialogVBox = new VBox(10, ordersTable);
        Scene dialogScene = new Scene(dialogVBox, 600, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
