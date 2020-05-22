public class MainForm ... {
    private JTextField field;
    private GameForm game;

    public MainForm() {
        game = new GameForm(MainForm.this);
    }

    public JTextField getField (){
        return field;
    }
}

public class GameField ... {
    private MainForm main;
    private JTextField field;

    public GameForm(final MainForm main) {
        this.main = main;
        this.field = main.getField();
    }
}