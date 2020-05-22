Rectangle rect1 = new Rectangle(10, 10, 20, 20);
rect1.setUserData( "aaa" );

Rectangle rect2 = new Rectangle(60, 10, 20, 20);
rect2.setUserData( "bbb" );

EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() 
{
    @Override
    public void handle( final MouseEvent ME ) 
    {
        Object obj = ME.getSource();  // you can also try ME.getTarget()

        if ( obj instanceof Rectangle )
        {
            System.out.println( ((Rectangle) obj).getUserData() );
        }
    }
};

rect1.setOnMouseClicked(event);
rect2.setOnMouseClicked(event);