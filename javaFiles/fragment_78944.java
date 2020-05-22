int highScore = 0;
if(correctScore.getText().toString().contains("correct") || correctScore.getText().toString().contains("wrong")){
       String[] separated = correctScore.getText().toString().split(":");
       highScore = Integer.parseInt(separated[1]);
}else{
       highScore = Integer.parseInt(correctScore.getText().toString());
}

int lowScore = 0;
if(wrongScore.getText().toString().contains("correct") || wrongScore.getText().toString().contains("wrong")){
       String[] separated = wrongScore.getText().toString().split(":");
       lowScore = Integer.parseInt(separated[1]);
}else{
       lowScore = Integer.parseInt(wrongScore.getText().toString());
}