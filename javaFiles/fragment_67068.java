public void setAngle(float angle){
     angle = Math.toRadians(angle);
     float speed = Math.sqrt(vx * vx + vy * vy); //magnitude of movement vector
     vx = speed * Math.cos(angle);
     vy = speed * Math.sin(angle);
}