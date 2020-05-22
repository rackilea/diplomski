Map<AppointmentRequest,Store> map = 
    new TreeMap(new Comparator<? super AppointmentRequest> comparator {
        int compare(AppointmentRequest o1, AppointmentRequest o2) {
            // return -1,0 or 1 based on the relative order of o1 and o2
        }
    });