public class Die {

    private static final int DEFAULT_NUM_FACES = 6;
    private int faceValue;
    private int numFaces;

    public Die() {

        this.faceValue = DEFAULT_NUM_FACES;
        this.numFaces = DEFAULT_NUM_FACES;

    }

    // getFaceValue() - returns the faceValue of the instance
    public int getFaceValue() {

        return faceValue;
    }

    // getNumFaces - return the numFaces of the Die
    public int getNumFaces() {
        return numFaces;
    }

    // setFaceValule - sets face values of the die to supplied value
    public int setValue(int faceValue) {
        return faceValue;
    }

    // toString returns a string representation of the face value in the form of
    // (faceValue)
    public String toString() {
        String result = Integer.toBinaryString(faceValue);
        return result;

    }

    public int roll() {

        faceValue = (int) (Math.random() * numFaces + 1);

        return faceValue;

    }

    public static void main(String[] args) {

        Die die1;
        Die die2;
        int sum;

        die1 = new Die();
        die1.roll();
        die2 = new Die();
        die2.roll();
        sum = (die1.getFaceValue()) + (die2.getFaceValue());
        System.out.println("Toss 0 generated a " + die1.getFaceValue() + " and a " + die2.getFaceValue()
                + " for a total of " + sum);

    }

}