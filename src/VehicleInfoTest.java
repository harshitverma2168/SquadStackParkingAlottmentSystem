import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleInfoTest {

     @Test
     public void testSetSlotNumber() {
         VehicleInfo vh = new VehicleInfo();
         vh.setSlotNumber(123);
         assertTrue(vh.getSlotNumber() == 123);
     }


    @Test
    public void testSetVehicleRegistrationNumber() {
        VehicleInfo vh = new VehicleInfo();
        vh.setVehicleRegistrationNumber("AB-BH-1234");
        assertTrue(vh.getVehicleRegistrationNumber().equals("AB-BH-1234"));
    }


    @Test
    public void testSetAge() {
        VehicleInfo vh = new VehicleInfo();
        vh.setDriverAge(24);
        assertTrue(vh.getDriverAge() == 24);
    }

}
