public enum Element {
    H(1, "Hydrogen", 1.008, -259.1),
    He(2, "Helium", 4.003, -272.2),
    Li(3, "Lithium", 6.941, 180.5),
    // ... 90+ others
    ;

    private static class Holder {
        static Map<Integer, Element> map = new HashMap<Integer, Element>();
    }

    private final int atomicNumber;
    private final String fullName;
    private final double atomicMass;
    private final double meltingPoint;

    private Element(int atomicNumber, String fullName, double atomicMass, double meltingPoint) {
        this.atomicNumber = atomicNumber;
        this.fullName = fullName;
        this.atomicMass = atomicMass;
        this.meltingPoint = meltingPoint;
        Holder.map.put(atomicNumber, this);
    }

    public static Element forAtomicNumber(int atomicNumber) {
        return Holder.map.get(atomicNumber);
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public double getMeltingPoint() {
        return meltingPoint;
    }
}