public ScoreSheet(ScoreControl _sc){
    sc = _sc;
    grid = new GridLayout(0, 1, 10, 3);
    setupUpperSection();
    setupLowerSection();
    setupFields();
    setupScorePanel();
    setupScoreSheet();
}

public ScoreControl() {
    sheet = new ScoreSheet(this);
}