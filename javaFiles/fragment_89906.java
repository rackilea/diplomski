double velocity = 0;
    double initVelX;
    double initVelZ;
    double time = 0;
    float x;
    float y;
    float z;

    public void bounce() {

        double initialVelocity = 0.1;       
        double speed = 1/2500.0;

        if(time == 0) {
            velocity = initialVelocity;
        }

        time += speed;
        velocity = velocity - 9.8 * speed;
        if(y + velocity < 0.1){
            velocity *= -1;
            velocity = initialVelocity;
        }
        y += velocity;
        setPosition(new Vector3f(getPosition().x,y,getPosition().z));
    }