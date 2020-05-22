traceln(format(date()) + ": changing shift size to " + shiftSize);

workers.set_capacity(shiftSize);    // Dynamically change the resource pool's capacity

// Set up the next dynamic event in the chain
create_ShiftChange(dynamicSchedule.getTimeoutToNextValue(), dynamicSchedule.getNextValue());