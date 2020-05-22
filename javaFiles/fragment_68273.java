void BeginContact(b2Contact* contact) {

  //check if fixture A was a ball
  void* bodyUserData = contact->GetFixtureA()->GetBody()->GetUserData();
  if ( bodyUserData )
    static_cast<Ball*>( bodyUserData )->startContact();

  //check if fixture B was a ball
  bodyUserData = contact->GetFixtureB()->GetBody()->GetUserData();
  if ( bodyUserData )
    static_cast<Ball*>( bodyUserData )->startContact();

}