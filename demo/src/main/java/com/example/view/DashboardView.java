package com.example.view;
import java.util.List;

// import com.example.controller.DashboardController;
// import com.example.model.Order;
// import com.example.model.OrderItem;
// import com.example.model.User;

// import javafx.scene.control.Label;
// import javafx.scene.layout.GridPane;

// public class DashboardView extends GridPane {
//     private DashboardController controller = new DashboardController();

//     public DashboardView() {
//         super();
//         initialize();
//     }

//     private void initialize() {
//         User user = controller.getUser();
//         List<Order> activeOrders = controller.getActiveOrders();

//         add(new Label("User: " + user.getFirstName() + " " + user.getLastName()), 0, 0);

//         if (activeOrders.isEmpty()) {
//             add(new Label("No active orders"), 0, 1);
//         } else {
//             int rowIndex = 1;
//             for (Order order : activeOrders) {
//                 GridPane orderGrid = new GridPane();
//                 orderGrid.setVgap(5);
//                 orderGrid.add(new Label("Order Number: " + order.getOrderNumber()), 0, 0);
//                 orderGrid.add(new Label("Order Status: " + order.getOrderStatus()), 0, 1);

//                 GridPane itemsGrid = new GridPane();
//                 itemsGrid.setVgap(2);
//                 int itemIndex = 0;
//                 for (OrderItem item : order.getItems()) {
//                     itemsGrid.add(new Label(item.getQuantity() + "x " + item.getItemName() + " - $" + item.getPrice()), 0, itemIndex++);
//                 }
//                 orderGrid.add(itemsGrid, 0, 2);
//                 orderGrid.add(new Label("Total Price: $" + order.getTotalPrice()), 0, 3);

//                 add(orderGrid, 0, rowIndex++);
//             }
//         }
//     }
// }
