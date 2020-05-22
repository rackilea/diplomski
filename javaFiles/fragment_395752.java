public static Machine getByName(String machineName) {

    for(Machine machine : Machine.values()){
        if(machine.getname().equals(machineName))
            return machine;
    }
    return null;
}