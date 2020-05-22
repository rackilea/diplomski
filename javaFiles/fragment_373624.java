public String getTypist() {
    ArrayList<Staff> staffWorking = new ArrayList<>(staffList);        
    staffWorking.removeIf(staff -> !(staff.isAvailable() && staff.getStaffID().contains("TY")));

    staffList.removeAll(staffWorking);

    Optional<Staff> typist = staffWorking.stream().findFirst();
    if(typist.isPresent()){
        return typist.getStaffID();
    }else{
        return "";
    }
}