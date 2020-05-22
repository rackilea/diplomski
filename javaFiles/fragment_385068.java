String completed = "completed ones \n";
String uncompleted = "uncompleted ones \n";

for (Klus k : alleKlussen) {

    if (k.getStatus().equals("completed")) {
      completed += k.toString() + ".\n"; //get all completed ones
    }
    else if (k.getStatus().equals("uncompleted")) {
       uncompleted += k.toString() + ".\n"; //get all uncompleted ones
    }
}