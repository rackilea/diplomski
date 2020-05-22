StringBuilder sb = new StringBuilder(hangmanScores.length);
for (int k = 0; k < hangmanScores.length; k++) {//displays the ______ in the text area
    sb.append(hangmanScores[k]);
    System.out.print(hangmanScores[k]);//testing purposes
}//end for
txtareaWord.setText(sb.toString());