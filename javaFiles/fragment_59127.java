deltaX = target.getX() - this.mPos.getX();
    deltaY = target.getY() - this.mPos.getY();
    // get the distance
    mDist = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    if(mDist > 0){
        if(mDist < mSpeed){
            mVelocityX = deltaX;
            mVelocityY = deltaY;
        }else{
            mVelocityX = (deltaX / mDist) * mSpeed;
            mVelocityY = (deltaY / mDist) * mSpeed;
        }
   }else{
        mVelocityX = 0;
        mVelocityY = 0; 
   }