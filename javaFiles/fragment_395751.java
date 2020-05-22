public void writeArrays(String machineName, int arrint) {

    int cost = 0;
    for(Machine machine : Machine.values()){
        if(machine.getname().equals(machineName)){
            cost = machine.getcost();
            break;
        }
    }
    //todo add rest of the code 
}