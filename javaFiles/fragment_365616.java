if (Game.KEY.equals(getResources().getText(R.string.easy_label))) {
        Question theQuestion = new Question();
        theQuestion.getARandomQuestion("easy");    
} else if (Game.KEY.equals(getResources().getText(R.string.medium_label))) {
        Question theQuestion = new Question();
        theQuestion.getARandomQuestion("medium");     
} else {
        Question theQuestion = new Question();
        theQuestion.getARandomQuestion("hard");     
}