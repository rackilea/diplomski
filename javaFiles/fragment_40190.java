if (isAnnualLicense){
    if (saleAmount <= 1000){
        return 10;
    } else if (saleAmount >= 1001 && saleAmount <= 10000) {
        return 15;
    } else { // saleAmount > 10001
        return 20;
    }
} else {
    if (saleAmount <= 10000) {
        return 10;
    } else if (saleAmount >= 100001 && saleAmount <= 50000) {
        return 15;
    } else { // saleAmount >= 50001
        return 20;
    }
}