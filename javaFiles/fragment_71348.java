...
public class GameWithNoHumanAlert extends Game{
    @Override
    protected void alertHumanPlayer(){
        // Do not show alert
        // HumanPlayerPanel.turnAlert();
    }
}

@Test
public void uiTest(){
    GameWithNoHumanAlert game = new GameWithNoHumanAlert();

    ...
    // Do your testing normally now.  

}