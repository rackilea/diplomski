for (TicketMachine machine : newMachine) {
    if (machine.getCost() == cost) {
        System.out.println("Machine no: " + newMachine.indexOf(machine));
        found = true;
        // break; // depends if you just want to find one or all of them
    }
}