world.setContactListener(new ContactListener() {

            @Override
        public void beginContact(Contact contact) {

         if(contact.getfixtureA.getBody().getUserData()=="body1"&&
               contact.getfixtureB.getBody().getUserData()=="body2")
            Colliding = true;
            System.out.println("Contact detected");
        }

        @Override
        public void endContact(Contact contact) {
            Colliding = false;
            System.out.println("Contact removed");
        }

        @Override
        public void postSolve(Contact arg0, ContactImpulse arg1) {
            // TODO Auto-generated method stub
        }

        @Override
        public void preSolve(Contact arg0, Manifold arg1) {
            // TODO Auto-generated method stub
        }
    });