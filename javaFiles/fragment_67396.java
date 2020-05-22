public void setLeftEye() {
     //Set the X Coord for the pupil
     //Mouse is to the left of the eye
     if(leftMouseX < LEFT_X) {
          leftPupilX = LEFT_X;
     //Mouse is to the right of the eye
     } else if(leftMouseX > LEFT_X + EYE_SIZE) {
          leftPupilX = LEFT_X + EYE_SIZE;
     //Mouse is in eye
     } else {
          leftPupilX = leftMouseX;
     }

     //Set the Y Coord for the pupil
     //Mouse is above the eye
     if(leftMouseY < LEFT_Y) {
          leftPupilY = LEFT_X;
     //Mouse is below the eye
     } else if(leftMouseY > LEFT_Y + EYE_SIZE) {
          leftPupilY = LEFT_Y + EYE_SIZE;
     //Mouse is in eye
     } else {
          leftPupilY = leftMouseY;
     }
}