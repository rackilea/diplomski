float acceleration=Gdx.input.getAccelerometerX(); // you can change it later to Y or Z, depending of the axis you want.


        if (Math.abs(acceleration) > 0.3f) // the accelerometer value is < -0.3 and > 0.3 , this means that is not really stable and the position should move
        {
           position.x -= acceleration * speed * dt; // we move it
           // now check for the animations


           if (acceleration < 0) // if the acceleration is negative
               currentFrame = animation.getKeyFrame(4 + (int) stateTime);
           else
               currentFrame = animation.getKeyFrame(8 + (int) stateTime);
           // this might be exactly backwards, you'll check for it
       } else {
           // the sensor has some small movements, probably the device is not moving so we want to put the idle animation
           currentFrame = animation.getKeyFrame(12);
       }