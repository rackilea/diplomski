int rate;
if (isAnnualLicense){
    if (saleAmount <= 1000){
        rate = 10;
    } else if (saleAmount >= 1001 && saleAmount <= 10000) {
        rate = 15;
    } else { // saleAmount > 10001
        rate = 20;
    }
} else {
    if (saleAmount <= 10000) {
        rate = 10;
    } else if (saleAmount >= 100001 && saleAmount <= 50000) {
        rate = 15;
    } else { // saleAmount >= 50001
        rate = 20;
    }
}
return rate;