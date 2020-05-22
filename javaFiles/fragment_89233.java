if (MotionEvent.ACTION_MOVE
                || motionEvent.getPointerId(motionEvent.getActionIndex()) == desiredPointerId)
    {
        // Create a dummy MotionEvent with only the data of the active pointer, and feed that into the VelocityTracker --
        // so our velocity is calculated only with respect to the active pointer, and not some weird average of all the pointers.
        // (Read: very clever hack!)
        MotionEvent culledMotionEvent = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(),
                motionEvent.getActionMasked(), // Using getAction() here will cause a nasty crash (unknown reason).
                motionEvent.getX(motionEvent.findPointerIndex(desiredPointerId)),
                motionEvent.getY(motionEvent.findPointerIndex(desiredPointerId)),
                motionEvent.getMetaState());
        velocityTracker.addMovement(culledMotionEvent);
        culledMotionEvent.recycle();
    }