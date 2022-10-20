package liga.medical.medicalmonitoring.core.solid.antiD;

public class TreatmentRoom {

    private final String masseur = "Ivanov A. A.";

    private final int roomNumber = 2;

    public TreatmentRoom() {
    }

    public String massage() {
        return "Massage is done by the masseur " + masseur +
                "in the room number " + roomNumber;
    }
}
