public class MyActivity extends Activity {
float weight, height;
SharedPreferences prefs;
EditText weightText, heightText;
TextView resultText;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
     prefs = PreferenceManager.getDefaultSharedPreferences(this);
    // get the references to the widgets
    weightText = (EditText)findViewById(R.id.weightText);
    heightText = (EditText)findViewById(R.id.heightText);
    resultText = (TextView)findViewById(R.id.resultLabel);
}

public void calculateClickHandler(View view) {
    // make sure we handle the click of the calculator button

    if (view.getId() == R.id.calculateButton) {
        // get the users values from the widget references
        weight = Float.parseFloat(weightText.getText().toString());
        height = Float.parseFloat(heightText.getText().toString());

        // calculate the bmi value

        float bmiValue = calculateBMI(weight, height);

        // interpret the meaning of the bmi value
        String bmiInterpretation = interpretBMI(bmiValue);

        // now set the value in the result text

        resultText.setText(bmiValue + "-" + bmiInterpretation);

    }


}

// the formula to calculate the BMI index

// check for http://en.wikipedia.org/wiki/Body_mass_index
private float calculateBMI (float weight, float height) {

    return (float) (weight * 4.88 / (height * height));
}


// interpret what BMI means
private String interpretBMI(float bmiValue) {

    if (bmiValue < 16) {
        return "Severely underweight";
    } else if (bmiValue < 18.5) {

        return "Underweight";
    } else if (bmiValue < 25) {

        return "Normal";
    } else if (bmiValue < 30) {

        return "Overweight";
    } else {
        return "Obese";
    }

}


public void SaveClickHandler(View view) {

    // here I want to Save the weight and the height value
    prefs = PreferenceManager.getDefaultSharedPreferences(view.getContext());
    SharedPreferences.Editor editor = prefs.edit();
    editor.putFloat("height", height);
    editor.putFloat("weight", weight);
    editor.apply();
}

public void LoadClickHandler(View view) {
    // here I want to Load the weight and the height value
    height = prefs.getFloat("height", 0.0f);  //Default value (0.0f)
    weight= prefs.getFloat("weight", 0.0f);   //Default value (0.0f)
    heightText.setText(String.valueOf(height));
    weightText.setText(String.valueOf(weight));

}