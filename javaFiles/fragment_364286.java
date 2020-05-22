String state = "";
int counter =0;
for (String line : lines1) {
     String[] array = line.split(",");
     if (array[0] != null && !array[0].isEmpty()){
            state = array[0];
            counter = 0;
     }
     else{
           counter++;
     }
     pw1.println(state+ counter +","+array[1]);
}