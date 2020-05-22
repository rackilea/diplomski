import org.threeten.bp.Period;

public class FormatPeriod {

    public static void main(String[] args) {
        String freeTrialString = "P3W";
        Period freeTrial = Period.parse(freeTrialString);
        String formattedPeriod = "" + freeTrial.getDays() + " days";
        System.out.println(formattedPeriod);
    }
}