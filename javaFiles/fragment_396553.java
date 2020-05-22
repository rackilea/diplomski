public void beginContact(Contact contact)
    {
        final Fixture x1 = contact.getFixtureA();
        final Fixture x2 = contact.getFixtureB();

        if (x2.getBody().getUserData().equals("player")&&x1.getBody().getUserData().equals("monster"))
        {
          Log.d("TAG", "Collisoion");
        }

    }