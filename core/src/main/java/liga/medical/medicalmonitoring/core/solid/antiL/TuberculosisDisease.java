package liga.medical.medicalmonitoring.core.solid.antiL;

public class TuberculosisDisease implements Disease{

    public TuberculosisDisease() {
    }

    @Override
    public void prescribeDiet() {
        throw new AssertionError("Diet is not recommended for this disease.");
    }
}
