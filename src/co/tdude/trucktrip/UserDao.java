package co.tdude.trucktrip;

import co.tdude.trucktrip.model.TruckTrip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public void addTrip(TruckTrip trip) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into trips(tripNumber,truckNumber,driverNumber,coDriverNumber,departureTime,arrivalTime," +
                                                            "mileage,gasUsed,gasPurchased,gasPrice,state,model,color) " +
                                                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1,  trip.getTripNumber());
            preparedStatement.setInt(2, trip.getTruckNumber());
            preparedStatement.setInt(3, trip.getDriverNumber());
            preparedStatement.setInt(4, trip.getCoDriverNumber());
            preparedStatement.setDate(5, new java.sql.Date(trip.getDepartureTime().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(trip.getDepartureTime().getTime()));
            preparedStatement.setDouble(7,  trip.getMileage());
            preparedStatement.setDouble(8,  trip.getGasUsed());
            preparedStatement.setDouble(9,  trip.getGasPurchased());
            preparedStatement.setDouble(10,  trip.getGasPrice());
            preparedStatement.setString(11,  trip.getState());
            preparedStatement.setString(12,  trip.getModel());
            preparedStatement.setString(13,  trip.getColor());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrip(int tripId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from trips where tripNumber=?");
            // Parameters start with 1
            preparedStatement.setInt(1, tripId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTrip(TruckTrip trip) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update trips set tripNumber=?,truckNumber=?,driverNumber=?,coDriverNumber=?,departureTime=?,arrivalTime=?," +
                                            "mileage=?,gasUsed=?,gasPurchased=?,gasPrice=?,state=?,model=?,color=? " +
                                            "where tripNumber=?");
            // Parameters start with 1
            preparedStatement.setInt(1,  trip.getTripNumber());
            preparedStatement.setInt(2, trip.getTruckNumber());
            preparedStatement.setInt(3, trip.getDriverNumber());
            preparedStatement.setInt(4, trip.getCoDriverNumber());
            preparedStatement.setDate(5, (Date) trip.getDepartureTime());
            preparedStatement.setDate(6, (Date) trip.getArrivalTime());
            preparedStatement.setDouble(7,  trip.getMileage());
            preparedStatement.setDouble(8,  trip.getGasUsed());
            preparedStatement.setDouble(9,  trip.getGasPurchased());
            preparedStatement.setDouble(10,  trip.getGasPrice());
            preparedStatement.setString(11,  trip.getState());
            preparedStatement.setString(12,  trip.getModel());
            preparedStatement.setString(13,  trip.getColor());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TruckTrip> getAllTrips() {
        List<TruckTrip> trips = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from trips");
            while (rs.next()) {
                TruckTrip trip = new TruckTrip();
                trip.setTruckNumber(rs.getInt("truckNumber"));
                trip.setDriverNumber(rs.getInt("driverNumber"));
                trip.setCoDriverNumber(rs.getInt("coDriverNumber"));
                trip.setTripNumber(rs.getInt("tripNumber"));
                trip.setDepartureTime(rs.getDate("departureTime"));
                trip.setArrivalTime(rs.getDate("arrivalTime"));
                trip.setMileage(rs.getDouble("mileage"));
                trip.setGasUsed(rs.getDouble("gasUsed"));
                trip.setGasPurchased(rs.getDouble("gasPurchased"));
                trip.setGasPrice(rs.getDouble("gasPrice"));
                trip.setState(rs.getString("state"));
                trip.setModel(rs.getString("model"));
                trip.setColor(rs.getString("color"));
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trips;
    }

    public List<TruckTrip> getExceptionTrips() {
        List<TruckTrip> trips = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from trips where (gasPurchased*gasPrice)>1000");
            while (rs.next()) {
                TruckTrip trip = new TruckTrip();
                trip.setTruckNumber(rs.getInt("truckNumber"));
                trip.setDriverNumber(rs.getInt("driverNumber"));
                trip.setCoDriverNumber(rs.getInt("coDriverNumber"));
                trip.setTripNumber(rs.getInt("tripNumber"));
                trip.setDepartureTime(rs.getDate("departureTime"));
                trip.setArrivalTime(rs.getDate("arrivalTime"));
                trip.setMileage(rs.getDouble("mileage"));
                trip.setGasUsed(rs.getDouble("gasUsed"));
                trip.setGasPurchased(rs.getDouble("gasPurchased"));
                trip.setGasPrice(rs.getDouble("gasPrice"));
                trip.setState(rs.getString("state"));
                trip.setModel(rs.getString("model"));
                trip.setColor(rs.getString("color"));
                trips.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trips;
    }

    public TruckTrip getUserById(int userId) {
        TruckTrip trip = new TruckTrip();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from trips where tripNumber=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                trip.setTruckNumber(rs.getInt("truckNumber"));
                trip.setDriverNumber(rs.getInt("driverNumber"));
                trip.setCoDriverNumber(rs.getInt("coDriverNumber"));
                trip.setTripNumber(rs.getInt("tripNumber"));
                trip.setDepartureTime(rs.getDate("departureTime"));
                trip.setArrivalTime(rs.getDate("arrivalTime"));
                trip.setMileage(rs.getDouble("mileage"));
                trip.setGasUsed(rs.getDouble("gasUsed"));
                trip.setGasPurchased(rs.getDouble("gasPurchased"));
                trip.setGasPrice(rs.getDouble("gasPrice"));
                trip.setState(rs.getString("state"));
                trip.setModel(rs.getString("model"));
                trip.setColor(rs.getString("color"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trip;
    }



}
