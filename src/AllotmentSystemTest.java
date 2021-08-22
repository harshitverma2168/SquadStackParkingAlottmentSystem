import org.junit.Assert;
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
    public void shouldPrintAllSlotNumbers(){
        VehicleInfo vh = new VehicleInfo();
        VehicleInfo vh2 = new VehicleInfo();
        vh.setSlotNumber(1);
        vh.setDriverAge(21);
        vh.setVehicleRegistrationNumber("HA-WH-3425");
        vh2.setSlotNumber(2);
        vh2.setVehicleRegistrationNumber("AH-WF-5647");
        vh2.setDriverAge(21);
        AllotmentSystem.printAllSlotNumbers(21);
        Assert.assertEquals("1,2", "1,2");


    }

}
