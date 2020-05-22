String statusMasterId = "2";
    if (ApplicationStatus.values()[Integer.parseInt(statusMasterId)] == ApplicationStatus.NotEligible) {
        System.out.println("Not eligible");
    }
    if (ApplicationStatus.NotEligible.compare(statusMasterId)) {
        System.out.println("Still not eligible using the compare() method");
    }