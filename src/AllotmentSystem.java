import java.util.ArrayList;

public class AllotmentSystem extends VehicleInfo {

    public static VehicleInfo leavingVehicle = new VehicleInfo();

    public static int[] parkingSlots = new int[0];

    public static ArrayList<VehicleInfo> list = new ArrayList<>();

    public static String getAllSlotNumbers(int age) {
        String allSlotNumbers = Constant.EMPTY_STRING;
        for (VehicleInfo vh : list) {
            if (vh.getDriverAge() == age) {
                allSlotNumbers += vh.getSlotNumber() + Constant.COMMA;
            }
        }
        if (allSlotNumbers.length() > 0) {
            allSlotNumbers = allSlotNumbers.substring(0, allSlotNumbers.length() - 1);
        }
        return allSlotNumbers;
    }

    public static void printAllSlotNumbers(int age) {
        String str = getAllSlotNumbers(age);
        if (str.length() == 0) {
            System.out.println("No parked car matches the query");
        } else {
            System.out.println(str);
        }
    }

    public static int slotNumberOfParkedVehicle(String registrationPlateNumber) {
        for (VehicleInfo vh : list) {
            if (vh.getVehicleRegistrationNumber().equals(registrationPlateNumber)) {
                return vh.getSlotNumber();
            }
        }
        return 0;
    }

    public static void printSlotNumberOfParkedCar(String registrationPlateNumber) {
        int slot = slotNumberOfParkedVehicle(registrationPlateNumber);
        if (slot <= 0) {
            System.out.println("No parked car matches the query");
        } else {
            System.out.println(slot);
        }
    }


    public static String getAllRegistrationPlateNumbers(int age) {
        String registrationNumbers = Constant.EMPTY_STRING;
        for (VehicleInfo vh : list) {
            if (vh.getDriverAge() == age) {
                registrationNumbers += vh.getVehicleRegistrationNumber() + Constant.COMMA;
            }
        }
        if (registrationNumbers.length() > 0) {
            registrationNumbers = registrationNumbers.substring(0, registrationNumbers.length() - 1);
        }
        return registrationNumbers;
    }

    public static void printAllRegistrationNumbers(int age) {
        String str = getAllRegistrationPlateNumbers(age);
        if (str.length() == 0) {
            System.out.println("No parked car matches the query");
        } else {
            System.out.println(str);
        }
    }

    public static void processDetails(String str) {
        switch (str.split(Constant.SPACE)[0].toLowerCase()) {
            case Constant.CREATE_PARKING_LOT:
                createParkingLot(Integer.parseInt(str.split(Constant.SPACE)[1]));
                break;
            case Constant.PARK:
                parkVehicleMessage(str.split(Constant.SPACE)[1], Integer.parseInt(str.split(Constant.SPACE)[3]));
                break;
            case Constant.SLOT_NUMBERS_FOR_DRIVER_OF_AGE:
                printAllSlotNumbers(Integer.parseInt(str.split(Constant.SPACE)[1]));
                break;
            case Constant.SLOT_NUMBER_FOR_CAR_WITH_NUMBER:
                printSlotNumberOfParkedCar(str.split(Constant.SPACE)[1]);
                break;
            case Constant.LEAVE:
                printLeavingCarMessage(Integer.parseInt(str.split(Constant.SPACE)[1]));
                break;
            case Constant.VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE:
                printAllRegistrationNumbers(Integer.parseInt(str.split(Constant.SPACE)[1]));
            default:
                break;
        }
    }

    public static boolean removeCarFromParking(int slotNumber) {
        try {
            parkingSlots[slotNumber] = 0;
            boolean isCarParked = false;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).getSlotNumber() == slotNumber) {
                    leavingVehicle = list.get(i);
                    list.remove(i);
                    isCarParked = true;
                    break;
                }
            }
            return isCarParked;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static void printLeavingCarMessage(int slotNumber) {
        boolean isCarParked = removeCarFromParking(slotNumber);
        if (isCarParked) {
            System.out.println("Slot number " + leavingVehicle.getSlotNumber() + " vacated, the car with vehicle registration number " + "\"" + leavingVehicle.getVehicleRegistrationNumber() + "\"" + " left the space, the driver of the car was of age " + leavingVehicle.getDriverAge());
        } else {
            System.out.println("slot is already vacant");
        }
    }


    public static void createParkingLot(int number) {
        if (number < 0) {
            throw new RuntimeException("Negatives are not allowed");
        }
        parkingSlots = new int[number + 1];
        System.out.println("Created parking of " + number + " slots");
    }


    public static boolean parkVehicle(String vehicleNumber, int age) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        boolean isSlotAvailable = false;
        int currentSlotNumber = 0;
        for (int i = 1; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == 0) {
                parkingSlots[i] = 1;
                currentSlotNumber = i;
                isSlotAvailable = true;
                break;
            }
        }
        if(isSlotAvailable) {
            vehicleInfo.setDriverAge(age);
            vehicleInfo.setVehicleRegistrationNumber(vehicleNumber);
            vehicleInfo.setSlotNumber(currentSlotNumber);
            list.add(vehicleInfo);
        }
        return isSlotAvailable;
    }

    public static void parkVehicleMessage(String vehicleNumber, int age) {
         boolean isSlotAvailable = parkVehicle(vehicleNumber, age);
        if (isSlotAvailable) {
            VehicleInfo vehicleInfo = list.get(list.size() - 1);
            System.out.println("Car with vehicle Registration number " + "\"" + vehicleInfo.getVehicleRegistrationNumber() + "\"" + " has been parked at slot number " + vehicleInfo.getSlotNumber());
        } else {
            System.out.println("Parking is Full");
        }
    }

}
