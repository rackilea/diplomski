public class DriverExam {
    int[] qmissed;

    public void makeMissedArray(){

        int smissedarray = totalIncorrect();
        qmissed = new int[smissedarray];
    }
    ...
}