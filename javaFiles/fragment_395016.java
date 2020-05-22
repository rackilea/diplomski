public ScoreSheet(){
    sc = new ScoreControl(this);
    grid = new GridLayout(0, 1, 10, 3);
    setupUpperSection();
    setupLowerSection();
    setupFields();
    setupScorePanel();
    setupScoreSheet();
}

public ScoreControl(ScoreSheet _sheet) {
    sheet = _sheet;
}