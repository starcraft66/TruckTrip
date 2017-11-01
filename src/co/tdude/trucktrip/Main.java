package co.tdude.trucktrip;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Truck Trip");
        stage.setWidth(1070);
        stage.setHeight(500);

        final Label label = new Label("Truck Trip");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn truckNumberCol = new TableColumn("Truck Number");
        TableColumn driverNumberCol = new TableColumn("Driver Number");
        TableColumn coDriverNumberCol = new TableColumn("Co Driver Number");
        TableColumn tripNumberCol = new TableColumn("Trip Number");
        TableColumn departureTimeCol = new TableColumn("Departure time");
        TableColumn returnTimeCol = new TableColumn("Return time");
        TableColumn mileageCol = new TableColumn("Mileage");
        TableColumn gasUsedCol = new TableColumn("Gas Used");
        TableColumn gasPurchasedCol = new TableColumn("Gas Purchased");
        TableColumn gasPriceCol = new TableColumn("Gas Price");
        TableColumn stateCol = new TableColumn("State");
        TableColumn modelCol = new TableColumn("Model");
        TableColumn colorCol = new TableColumn("Color");

        table.getColumns().addAll(truckNumberCol, driverNumberCol, coDriverNumberCol, tripNumberCol, departureTimeCol, returnTimeCol, mileageCol, gasUsedCol, gasPurchasedCol,gasPriceCol, stateCol, modelCol, colorCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
