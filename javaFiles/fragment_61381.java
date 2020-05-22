// re-get the aviableSlots
availableSlots = cluster.getAvailableSlots(specialSupervisor);
 
// since it is just a demo, to keep things simple, we assign all the
// executors into one slot.
cluster.assign(availableSlots.get(0), topology.getId(), executors);