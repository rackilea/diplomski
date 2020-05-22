public void velocityManagement(int speed){
        if (speed > 0){
            System.out.println("Pressing gas pedal");
            System.out.println("Velocity increased to " + velocity + " km/h");
        } else{
            System.out.println("Pressing break");
            System.out.println("Velocity decreased to " + velocity + " km/h");
        }
        velocity += speed;
}