public void beginContact(Contact contact)
{
...
   if((userDataA == Tomb.UserData.GROUND || userDataB == Tomb.UserData.GROUND) 
      && (userDataA == Tomb.UserData.PLAYER_FEET  || userDataB == Tomb.UserData.PLAYER_FEET))
        {   
            Gdx.app.log("collision", "start");
            counter.incCollision();
        } 
}

public void endContact(Contact contact)
{
...
if((userDataA == Tomb.UserData.GROUND || userDataB == Tomb.UserData.GROUND) 
  && (userDataA == Tomb.UserData.PLAYER_FEET  || userDataB == Tomb.UserData.PLAYER_FEET))
    {   
        Gdx.app.log("collision", "stop");
        counter.decCollision();
    } 
}