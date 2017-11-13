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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Summary {
    final static UserDao dao = new UserDao();

    private static TableView table = new TableView();
    private final ObservableList<TruckTrip> data =
            FXCollections.observableArrayList(
                    dao.getAllTrips()
            );
    private static Scene scene;

    final HBox hb = new HBox();

    public void init(Stage stage) {
        scene = new Scene(new Group());
        stage.setTitle("Summary Trip");
        stage.setWidth(1070);
        stage.setHeight(500);

        final Label label = new Label("Summary Trip");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn truckNumberCol = new TableColumn("Truck Number");
        truckNumberCol.setMinWidth(100);
        truckNumberCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Integer>("truckNumber")
        );
        TableColumn driverNumberCol = new TableColumn("Driver Number");
        driverNumberCol.setMinWidth(100);
        driverNumberCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Integer>("driverNumber")
        );

        TableColumn tripNumberCol = new TableColumn("Trip Number");
        tripNumberCol.setMinWidth(100);
        tripNumberCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Integer>("tripNumber")
        );
        TableColumn departureTimeCol = new TableColumn("Departure time");
        departureTimeCol.setMinWidth(100);
        departureTimeCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Date>("departureTime")
        );
        TableColumn returnTimeCol = new TableColumn("Return time");
        returnTimeCol.setMinWidth(100);
        returnTimeCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Date>("arrivalTime")
        );
        TableColumn mileageCol = new TableColumn("Mileage");
        mileageCol.setMinWidth(100);
        mileageCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Double>("mileage")
        );
        TableColumn totalExpenses = new TableColumn("Total Expenses");
        totalExpenses.setMinWidth(100);
        totalExpenses.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, Double>("totalExpense")
        );
        TableColumn stateCol = new TableColumn("State");
        stateCol.setMinWidth(100);
        stateCol.setCellValueFactory(
                new PropertyValueFactory<TruckTrip, String>("state")
        );

        table.setItems(data);
        table.getColumns().addAll(truckNumberCol, driverNumberCol, tripNumberCol, departureTimeCol, returnTimeCol, mileageCol, totalExpenses, stateCol);

        final TextField addTruckNumber = new TextField();
        addTruckNumber.setPromptText("Truck Number:");
        addTruckNumber.setMaxWidth(truckNumberCol.getPrefWidth());
        final TextField addDriverNumber = new TextField();
        addDriverNumber.setMaxWidth(driverNumberCol.getPrefWidth());
        addDriverNumber.setPromptText("Driver Number:");

        final TextField addTripNumber = new TextField();
        addTripNumber.setMaxWidth(driverNumberCol.getPrefWidth());
        addTripNumber.setPromptText("Trip Number:");
        final TextField addDepartureTime = new TextField();
        addDepartureTime.setMaxWidth(driverNumberCol.getPrefWidth());
        addDepartureTime.setPromptText("Departure time:");
        final TextField addReturnTime = new TextField();
        addReturnTime.setMaxWidth(driverNumberCol.getPrefWidth());
        addReturnTime.setPromptText("Return time:");
        final TextField addMileage = new TextField();
        addMileage.setMaxWidth(driverNumberCol.getPrefWidth());
        addMileage.setPromptText("Mileage:");

        final TextField addTotalExpenses = new TextField();
        addTotalExpenses.setMaxWidth(driverNumberCol.getPrefWidth());
        addTotalExpenses.setPromptText("Total Expenses:");

        final TextField addState = new TextField();
        addState.setMaxWidth(driverNumberCol.getPrefWidth());
        addState.setPromptText("State:");

        final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    data.add(new TruckTrip(
                            Integer.parseInt(addTruckNumber.getText()),
                            Integer.parseInt(addDriverNumber.getText()),
                            Integer.parseInt(addTripNumber.getText()),
                            df.parse(addDepartureTime.getText()),
                            df.parse(addReturnTime.getText()),
                            Double.parseDouble(addMileage.getText()),
                            Double.parseDouble(addTotalExpenses.getText()),
                            addState.getText()
                    ));
                } catch (java.lang.Exception ex) {
                    ex.printStackTrace();
                }
                addTruckNumber.clear();
                addDriverNumber.clear();
                addTripNumber.clear();
                addDepartureTime.clear();
                addReturnTime.clear();
                addMileage.clear();
                addTotalExpenses.clear();
                addState.clear();
            }
        });

        final Button main = new Button("MainReport");
        main.setOnAction(e -> {
            stage.setScene(Main.getScene());
            table.setItems(data);
        });

        final Button exception = new Button("ExceptionReport");
        exception.setOnAction(e -> {
            stage.setScene(Main.getExRep().getScene());
            table.setItems(data);
        });

        hb.getChildren().addAll(addTruckNumber, addDriverNumber,addTripNumber, addDepartureTime, addReturnTime, addMileage, addTotalExpenses, addState, addButton, main, exception);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static Scene getScene() {
        table.setItems(FXCollections.observableArrayList(
                dao.getAllTrips()
        ));
        return scene;
    }
}
