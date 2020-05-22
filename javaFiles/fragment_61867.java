class CarClass {

    // [...]

    void up(){
        x += sin(steering) * speed;
        y -= cos(steering) * speed;
    }
    void down(){
        x -= sin(steering) * speed;
        y += cos(steering) * speed;
    }

    // [...]
}