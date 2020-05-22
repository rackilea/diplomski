private static final Predicate<Staff> isATypistWorker = 
    staff -> staff.isAvailable() && staff.getStaffID().contains("TY");

public String getTypist() {
    ArrayList<Staff> typistWorkers = staffList.stream()
         .parallel()
         .filter(isATypistWorker)
         .distinct()
         .collect(Collectors.toCollection(ArrayList::new));

    staffList.removeAll(typistWorkers);
    staffWorkers.addAll(typistWorkers);

    Optional<Staff> typist = typistWorkers.stream().findFirst();

    return typist.isPresent() ? typist.getStaffID() : "";
}