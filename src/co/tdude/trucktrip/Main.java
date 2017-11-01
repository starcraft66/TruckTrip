package co.tdude.trucktrip;

import co.tdude.trucktrip.model.TruckTrip;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main extends Application{

    private TableView table = new TableView();
    private final ObservableList<TruckTrip> data =
            FXCollections.observableArrayList(

            );

    final HBox hb = new HBox();

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

        final TextField addTruckNumber = new TextField();
        addTruckNumber.setPromptText("Truck Number:");
        addTruckNumber.setMaxWidth(truckNumberCol.getPrefWidth());
        final TextField addDriverNumber = new TextField();
        addDriverNumber.setMaxWidth(driverNumberCol.getPrefWidth());
        addDriverNumber.setPromptText("Driver Number:");
        final TextField addCoDriverNumber = new TextField();
        addCoDriverNumber.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addCoDriverNumber.setPromptText("Co Driver Number:");
        final TextField addTripNumber = new TextField();
        addTripNumber.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addTripNumber.setPromptText("Trip Number:");
        final TextField addDepartureTime = new TextField();
        addDepartureTime.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addDepartureTime.setPromptText("Departure time:");
        final TextField addReturnTime = new TextField();
        addReturnTime.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addReturnTime.setPromptText("Return time:");
        final TextField addMileage = new TextField();
        addMileage.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addMileage.setPromptText("Mileage:");
        final TextField addGasUsed = new TextField();
        addGasUsed.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addGasUsed.setPromptText("Gas Used:");
        final TextField addGasPurchased = new TextField();
        addGasPurchased.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addGasPurchased.setPromptText("Gas Purchased:");
        final TextField addGasPrice = new TextField();
        addGasPrice.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addGasPrice.setPromptText("Gas Price:");
        final TextField addState = new TextField();
        addState.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addState.setPromptText("State:");
        final TextField addModel = new TextField();
        addModel.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addModel.setPromptText("Model:");
        final TextField addColor = new TextField();
        addColor.setMaxWidth(coDriverNumberCol.getPrefWidth());
        addColor.setPromptText("Color:");
        final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    data.add(new TruckTrip(
                            Integer.parseInt(addTruckNumber.getText()),
                            Integer.parseInt(addDriverNumber.getText()),
                            Integer.parseInt(addCoDriverNumber.getText()),
                            Integer.parseInt(addTripNumber.getText()),
                            df.parse(addDepartureTime.getText()),
                            df.parse(addReturnTime.getText()),
                            Double.parseDouble(addMileage.getText()),
                            Double.parseDouble(addGasUsed.getText()),
                            Double.parseDouble(addGasPurchased.getText()),
                            Double.parseDouble(addGasPrice.getText()),
                            addState.getText(),
                            addModel.getText(),
                            addColor.getText()
                    ));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                addTruckNumber.clear();
                addDriverNumber.clear();
                addCoDriverNumber.clear();
            }
        });

        hb.getChildren().addAll(addTruckNumber, addDriverNumber, addCoDriverNumber, addTripNumber, addDepartureTime, addReturnTime, addMileage, addGasUsed, addGasPurchased, addGasPrice, addState, addModel, addColor, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
