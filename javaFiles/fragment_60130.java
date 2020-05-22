float leftWheel = 1.0f;
float rightWheel = 0.5f;
float vehicleWidth = 1.0f;

float diff = rightWheel - leftWheel;
float rotation = (float) Math.atan2(diff, vehicleWidth);