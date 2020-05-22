String currLine = input1.nextLine();
//This only needed if you are not sure if the input will have leading/trailing space
currLine = currLine.trim();
String[] split = currLine.split("\\s+");
//Ensuring the line read was properly split
if(split.length == 2) {
    //split[0] will have the first hand
    player1.add(split[0]);
    //split[1] will have the second hand
    player2.add(split[1]);
}