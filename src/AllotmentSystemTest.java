import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AllotmentSystemTest {

    @Test
    public void shouldReturnLengthOfTheParkingLotForPositiveNumber() {
        AllotmentSystem.createParkingLot(19);
        Assert.assertEquals(19, AllotmentSystem.parkingSlots.length - 1);
    }

    @Test
    public void shouldThrowExceptionForNegativeValues() {
        try {
            AllotmentSystem.createParkingLot(-1);
        } catch (RuntimeException var2) {
            Assert.assertEquals("Negatives are not allowed", var2.getMessage());
        }
    }

    @Test
    public void shouldPrintAllSlotNumbers() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals("1,2", AllotmentSystem.getAllSlotNumbers(21));
    }

    @Test
    public void shouldReturnEmptyStringForNoMatchingSlotNumbers() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals("", AllotmentSystem.getAllSlotNumbers(18));
        AllotmentSystem.list.clear();
    }

    @Test
    public void shouldReturnSlotNumbersForParkedVehicles() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals(2, AllotmentSystem.slotNumberOfParkedVehicle("AH-WF-5647"));
        AllotmentSystem.list.clear();
    }

    @Test
    public void shouldReturnZeroForSlotNumbersForNoMatchingParkedVehicles() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals(0, AllotmentSystem.slotNumberOfParkedVehicle("AH-WF-5648"));
        AllotmentSystem.list.clear();
    }


    @Test
    public void shouldReturnAllRegistrationPlateNumbersForParkedVehiclesForParticularAge() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals("HA-WH-3425,AH-WF-5647", AllotmentSystem.getAllRegistrationPlateNumbers(21));
        AllotmentSystem.list.clear();
    }


    @Test
    public void shouldReturnEmptyStringForRegistrationPlateNumbersForNoMatcingParkedVehiclesForParticularAge() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals("", AllotmentSystem.getAllRegistrationPlateNumbers(18));
        AllotmentSystem.list.clear();
    }

    @Test
    public void shouldReturnTrueIfCarisParked() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals(true, AllotmentSystem.removeCarFromParking(1));
        AllotmentSystem.list.clear();
    }


    @Test
    public void shouldReturnFalseOrExceptionIfCarisNotParkedOrSlotIsVacant() {
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.list.add(vh);
        AllotmentSystem.list.add(vh2);
        Assert.assertEquals(false, AllotmentSystem.removeCarFromParking(3));
        AllotmentSystem.list.clear();
    }


    @Test
    public void shouldReturnTrueIfSlotAvailableForParking() {
        AllotmentSystem.parkingSlots = new int[2];
        Assert.assertEquals(true, AllotmentSystem.parkVehicle("HA-WH-3425", 21));
        AllotmentSystem.list.clear();
    }

    @Test
    public void shouldReturnFalseIfSlotNotAvailableForParking() {
        AllotmentSystem.parkingSlots = new int[0];
        Assert.assertEquals(false, AllotmentSystem.parkVehicle("HA-WH-3426", 21));
        AllotmentSystem.list.clear();
    }
}
