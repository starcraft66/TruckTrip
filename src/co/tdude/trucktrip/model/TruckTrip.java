package co.tdude.trucktrip.model;

import java.util.Date;

public class TruckTrip {
    protected int truckNumber;
    protected int driverNumber;
    protected int coDriverNumber;
    protected int tripNumber;
    protected Date departureTime;
    protected Date arrivalTime;
    protected double mileage;
    protected double gasUsed;
    protected double gasPurchased;
    protected double gasPrice;
    protected String state;
    protected String model;
    protected String color;

    public TruckTrip(int truckNumber, int driverNumber, int coDriverNumber, int tripNumber, Date departureTime, Date arrivalTime, double mileage, double gasUsed, double gasPurchased, double gasPrice, String state, String model, String color) {
        this.truckNumber = truckNumber;
        this.driverNumber = driverNumber;
        this.coDriverNumber = coDriverNumber;
        this.tripNumber = tripNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.mileage = mileage;
        this.gasUsed = gasUsed;
        this.gasPurchased = gasPurchased;
        this.gasPrice = gasPrice;
        this.state = state;
        this.model = model;
        this.color = color;
    }

    public int getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(int truckNumber) {
        this.truckNumber = truckNumber;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public int getCoDriverNumber() {
        return coDriverNumber;
    }

    public void setCoDriverNumber(int coDriverNumber) {
        this.coDriverNumber = coDriverNumber;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(double gasUsed) {
        this.gasUsed = gasUsed;
    }

    public double getGasPurchased() {
        return gasPurchased;
    }

    public void setGasPurchased(double gasPurchased) {
        this.gasPurchased = gasPurchased;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
