//rotate player
float playerRotation = left ? 1 : -1; //TODO (should involve delta time...)
inst.transform.rotate(Vector3.Y, playerRotation);

//translate player
float playerZtranslation = forward ? 0.2f : -0.2f; //TODO (should involve delta time...)
inst.translate(0, 0, playerZtranslation );

//move camera to position of player.
inst.transform.getTranslation(camera.position);

//rotate camera to face same direction as player
inst.transform.getRotation(mTempRotation); //mTempRotation is a member Quaternion variable to avoid unnecessary instantiations every frame.
camera.direction.set(0,0,-1).rotate(mTempRotation);//reset and rotate to match current player angle

//rotate translation vector to match angle of player
mTempTranslation.set(0,0,5).rotate(mTempRotation); //mTempTranslation is a member Vector3 variable to avoid unnecessary instantiations every frame.

//and apply it.
cam.position.add(mTempTranslation);