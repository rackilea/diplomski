package spikespaz.engine.main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

// Created by spike on 7/3/2017.
public final class Camera {
    private Camera() {}

    private float moveSpeed = 0.2f;
    private Vector3f position = new Vector3f(0, 0, 0);

    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
    }

            public void updateKeyInput() {
        Vector3f direction = new Vector3f(0, 0, 0);

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            direction.x = 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            direction.x = -1;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            direction.y = -1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            direction.y = 1;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            direction.z = 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            direction.z = -1;
        }

        translate(direction);
    }

    private void translate(Vector3f direction) {
        Vector3f normalized = direction.normalise(null);
        Vector3f.add(position, (Vector3f) normalized.scale(moveSpeed), position);
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}