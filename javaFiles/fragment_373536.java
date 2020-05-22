//rotate and transform player variables
mPlayerYAngle += left ? 1 : -1; //TODO (should involve delta time...)
mPlayerPosition.add(0, 0, forward ? 0.2f : -0.2f); //TODO (should involve delta time...)

//apply changes by resetting transform to identity and applying variables
inst.transform.idt().translate(mPlayerPosition).rotate(Vector3.Y, mPlayerYAngle );

//move camera to position of player.
camera.position.set(mPlayerPosition);

//rotate camera to face same direction as player
camera.direction.set(0,0,-1).rotate(mPlayerYAngle ,0,1,0);//reset and rotate to match current player angle

//rotate translation vector to match angle of player
mTempTranslation.set(0,0,5).rotate(mPlayerYAngle ,0,1,0);

//and apply it.
cam.position.add(mTempTranslation);