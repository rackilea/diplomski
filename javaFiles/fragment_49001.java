public String pickWinner(String userChoice, String cpuChoice) {
String result = " ";
if (userChoice.equalsIgnoreCase("rock")) { 
    if (cpuChoice.equalsIgnoreCase("rock")){
        result = "tie"; 
    }
    else if (cpuChoice.equalsIgnoreCase("paper")){
        result = "Computer";
    }
    else if (cpuChoice.equalsIgnoreCase("scissors")){
        result = "User";
    }       
}
else if (userChoice.equalsIgnoreCase("paper")){
    if (cpuChoice.equalsIgnoreCase("paper")){
        result = "tie";
    }
    else if (cpuChoice.equalsIgnoreCase("rock")){
        result = "User";
    }
    else if (cpuChoice.equalsIgnoreCase("scissors")){
        result = "Computer";
    }
}
else if (userChoice.equalsIgnoreCase("Scissors")){
    if (cpuChoice.equalsIgnoreCase("scissors")){
        result = "tie";
    }
    else if (cpuChoice.equalsIgnoreCase("rock")){
        result = "Computer";
    }
    else if (cpuChoice.equalsIgnoreCase("Paper")){
        result = "User";
    }
}
return result;