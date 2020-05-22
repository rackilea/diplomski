import org.json.JSONObject;
import android.annotation.SuppressLint;

public class HandleJSON {
    private String make = "make";
    private String model = "model";
    private String sixMonthRate = "sixMonthRate";
    private String twelveMonthRate = "twelveMonthRate";
    private String dateofFirstRegistration = "dateofFirstRegistration";
    private String yearOfManufacture = "yearOfManufacture";
    private String cylinderCapacity = "cylinderCapacity";
    private String co2Emissions= "co2Emissions";

    public HandleJSON(String url) {this.urlString = url;}
    public void setURL(String url){ this.urlString = url;}
    public String getMake() {return make;}
    public String getModel() {return model;}
    public String getSixMonthRate() {return sixMonthRate;}
    public String getTwelveMonthRate() {return twelveMonthRate;}
    public String getDateofFirstRegistrationegistration() {return dateofFirstRegistration;}    
    public String getYearOfManufacture() {return yearOfManufacture;}
    public String getCylinderCapacity() {return cylinderCapacity;}
    public String getCo2Emissions() {return co2Emissions;}

    @SuppressLint("NewApi")
    public void readAndParseJSON(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            make = reader.getString("make");
            model = reader.getString("model");
            sixMonthRate = reader.getString("sixMonthRate");
            twelveMonthRate = reader.getString("twelveMonthRate");
            dateofFirstRegistration= reader.getString("dateOfFirstRegistration");
            yearOfManufacture= reader.getString("yearOfManufacture");
            cylinderCapacity= reader.getString("cylinderCapacity");
            co2Emissions= reader.getString("co2Emissions");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}