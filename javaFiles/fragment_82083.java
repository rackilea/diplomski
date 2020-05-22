public class P12 {

int numNotes = 13;
public GuitarString[] gStrings = new GuitarString[13];
public String[] strings = new String[]{"C", "C#","D","D#","E","F","F#","G","G#","A","A#","B","H"};

public static void main(String[] args) {

    // Instantiate object
    P12 p12 = new P12();

    for(int index = 0; index <= p12.numNotes; index++){
        double frequency = 440.0 * Math.pow(1.05956, index - 9);
        p12.strings[index] = new p12.GuitarString(frequency);
    }
}

private class GuitarString {

    double freq;

    GuitarString(double frequency) {
        freq = frequency;
    }

}