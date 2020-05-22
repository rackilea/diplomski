public String getTypist() {
    for (Staff s : staffList) {
        if (s.getStaffID().contains("TY") && s.isAvailable()){
            staffList.remove(s);
            staffWorking.add(s);
            return s.getStaffID();
        }
    }

    return "";
}