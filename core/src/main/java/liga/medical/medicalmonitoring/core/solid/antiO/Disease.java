package liga.medical.medicalmonitoring.core.solid.antiO;

public class Disease {

    private String name;

    public Disease(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        String symptom = "";
        switch (name) {
            case "Tuberculosis":
                symptom = "Cough";
                break;
            case "Gastritis":
                symptom = "Stomach pain";
                break;
            default:
                symptom = "The symptoms of this disease are not known";
        }
        return symptom;
    }
}
