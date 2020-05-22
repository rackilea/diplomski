public String toString() {
    String str = "The zoo is capable of keeping " + park.length + "animals\nThe following is the list of animals currently in the zoo.";
    for(int i = 0; i < park.length; i++)
        str += '\n' + "cage " + i + " status: " + park[i];

    return str;

}