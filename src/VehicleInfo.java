public class VehicleInfo {

    private int slotNumber;

    private String vehicleRegistrationNumber;

    private int driverAge;

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getVehicleRegistrationNumber() {
        return this.vehicleRegistrationNumber;
    }

    public int getDriverAge() {
        return this.driverAge;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }
}
