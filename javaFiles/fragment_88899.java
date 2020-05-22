String timePeriodValue = "Bi-Weekly";

DropDownChoice timePeriod = new DropDownChoice("timePeriod",
  new PropertyModel(this, "timePeriodValue"),
  Arrays.asList(/* your options */),
  new IChoiceRenderer() {
    // ...
// Again, this is pseudocode only