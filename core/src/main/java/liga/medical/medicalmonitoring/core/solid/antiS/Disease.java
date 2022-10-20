package liga.medical.medicalmonitoring.core.solid.antiS;

import java.util.Arrays;
import java.util.List;

public class Disease {

    private String name;

    public Disease(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return "Symptom";
    }

    public List<String> getPatients() {
        return Arrays.asList(
                "Ivanov A. A",
                "Vasiliev S. V."
        );
    }

    public void savePatient(String name) {
        System.out.println("Patient " + name + "saved.");
    }
}
