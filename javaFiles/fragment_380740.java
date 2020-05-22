int total = 1000000;
    int reducedBy = 100000;
    while (total > 0 && reducedBy >= 1) {
        System.out.println(total);
        total -= reducedBy;
        if (total == reducedBy)
            reducedBy /= 10;
    }
    System.out.println(total);