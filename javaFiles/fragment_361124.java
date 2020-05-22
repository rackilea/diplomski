@Override
public void clicked(InputEvent event, float x, float y) {

    Vector3 touch = new Vector3(x, y, 0);
    camera.unproject(touch);

    System.out.println("Screen coordinates translated to world coordinates: "
        + "X: " + touch.x + " Y: " + touch.y);

    }
}