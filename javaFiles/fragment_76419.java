public static void main(String [] args)
{
    ...
    Stage myStage = new Stage();
    Player myPlayer = new Player(myStage);

    myStage.addActor(myPlayer);
    ...
}

...

public class Player extends Actor
{

    Stage myStage;        

    public Player(Stage _stage)
    {
        myStage = _stage;

        myStage.addActor(<another Actor object>);
    }
}