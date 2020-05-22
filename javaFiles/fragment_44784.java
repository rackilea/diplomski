public class Weather {

private static final int Uninitialized = -999;

public static void main(String[] args) {

    int[] low = new int[args.length];

    for (int i = 0; i < args.length; i++) {
        System.out.print(args[i] + " ");
        low[i] = Integer.parseInt(args[i]);
    }
    System.out.println("\n");

    Weather.Temperature temp = FindLowestTempInArray(low);
    System.out.println(temp.temperature + "   " + temp.day);

}

public static Weather.Temperature FindLowestTempInArray(int[] T) {

    Weather.Temperature temp=new Weather.Temperature();
    temp.temperature = Uninitialized;
    temp.day = 0;
    for (int day = 0; day < T.length; day++) {
        if (T[day] != Uninitialized
                && (T[day] < temp.temperature || temp.temperature == Uninitialized)) {
            temp.temperature = T[day];
            temp.day = day;
        }
    }
    return temp;
}

static class Temperature{
    private int temperature;
    private int day;

    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
}