public double getTaxesWithheld() {

    over100k = Math.max(taxableIncome-100000, 0);
    taxableIncome -= over100k;
    over50k = Math.max(taxableIncome-50000, 0);
    taxableIncome -= over50k;

    taxesWitheld = taxesWitheld + (.25 * over100k);
    taxesWitheld = taxesWitheld + (.15 * over50k);
    taxesWitheld = taxesWitheld + (.1 * taxableIncome);
    return taxesWitheld;
}