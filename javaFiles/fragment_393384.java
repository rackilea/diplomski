int untaxed = income;
int tax = 0;
for(TaxGroup taxGroup : TAX_GROUPS) {
    if(untaxed > taxGroup.lowerLimit) {
        tax += (untaxed - taxGroup.lowerLimit) * taxGroup.rate;
        untaxed = taxGroup.lowerLimit;
    }
}