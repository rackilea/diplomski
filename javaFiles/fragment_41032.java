public class MapInputProcessor implements InputProcessor {
    Vector3 last_touch_down = new Vector3();

    ...

    public boolean touchDragged(int x, int y, int pointer) {
        moveCamera( x, y );     
        return false;
    }

    private void moveCamera( int touch_x, int touch_y ) {
        Vector3 new_position = getNewCameraPosition( touch_x, touch_y );

        if( !cameraOutOfLimit( new_position ) )
            stage.getCamera().translate( new_position.sub( stage.getCamera().position ) );

        last_touch_down.set( touch_x, touch_y, 0);
    }

    private Vector3 getNewCameraPosition( int x, int y ) {
        Vector3 new_position = last_touch_down;
        new_position.sub(x, y, 0);
        new_position.y = -new_position.y;
        new_position.add( stage.getCamera().position );

        return new_position;
    }

    private boolean cameraOutOfLimit( Vector3 position ) {
        int x_left_limit = WINDOW_WIDHT / 2;
        int x_right_limit = terrain.getWidth() - WINDOW_WIDTH / 2;
        int y_bottom_limit = WINDOW_HEIGHT / 2;
        int y_top_limit = terrain.getHeight() - WINDOW_HEIGHT / 2;

        if( position.x < x_left_limit || position.x > x_right_limit )
            return true;
        else if( position.y < y_bottom_limit || position.y > y_top_limit )
            return true;
        else
          return false;
}


    ...
}