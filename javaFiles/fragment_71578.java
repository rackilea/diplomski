public class Player {
    //holding commands as strings is a little bug prone, consider creating a custom class or enum
    ArrayList<String> commandsHopper=new  ArrayList<String>(); 

    //replace with some sort of Vector2i as improvement
    double[] targetCoOrdinates=new double[2]; 

    public void addCommand(String command){
        commandsHopper.add(command); //commands added at the top of arraylist
    }

    public void update(double timeSlice){
        //Called once, every game loop

        if (isAtTarget()){
            getNextTarget();
        }
        moveTowardsTarget(timeSlice);

    }

    public void getNextTarget(){
        if (commandsHopper.isEmpty()==false){
            //commands used from bottom of the arraylist
            targetCoOrdinates=determineTargetFromCommand(commandsHopper.get(0));
            commandsHopper.remove(0); //inefficient with arraylist, consider other collections
        }
    }

}