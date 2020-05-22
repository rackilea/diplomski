import java.awt.Rectangle;

public class Physics {
    public static boolean isColliding(int[] ob1Hitbox, int[] ob2Hitbox) {
        return toRectangle(ob1Hitbox).intersects(toRectangle(ob2Hitbox));
    }

    private static Rectangle toRectangle(int[] hitbox) {
        int x = hitbox[0];
        int y = hitbox[1];
        int width = hitbox[2] - x;
        int height = y - hitbox[3];
        return new Rectangle(x, y, width, height);
    }
}