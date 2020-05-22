StringBuilder sb = new StringBuilder(25);
for (int counter = 0; counter < possibleAnswers.length; counter++){
    if (counter < 25){
        sb.append(alpha[counter] + ": " + possibleAnswers[counter] + "\n");
    }
    if (counter >= 26){
        sb.append(alpha[26] + a + ": " + possibleAnswers[counter] + "\n");
        a++;
    }
}
return sb.toString();