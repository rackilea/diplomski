Class GradeReport{
//The values we get from the user
private string name
private int score1
private int score2
private int score3

//Things we are told we need to calculate at some point
private double average
private char grade

public GradeReport(){
// Get values from the user and validate them

// We will need to assign the values to the fields in some way 
// here...do we have somewhere else to do that already written?
}

public GradeReport(String name, int score1, int score2, int score3){
// We will probably want to assign these parameters to the fields here
}

public void calculateAverage(){
// You already have that pretty much, but you prob don't need to output it to the screen
}

public void calculateGrade(){
//Some sort of if...else logic is needed to work out the grade from the avg
}

public String toString(){
// We need to output our various bit of information here in a nicely formatted String
// I would recommend looking at String.Format() method in the Java API as a good starting point.

// At some point you will need to call calculateGrade and calculateAverage. It would 
// be useful to do that before you output to screen. It can either be done in here or 
// in your main class before you call toString()
}
}