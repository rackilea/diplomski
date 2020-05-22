double taxRate;
if (yearlyCompensation < 45282) {
    taxRate = 0.15;
} else if (yearlyCompensation < 90536) {
    taxRate = 0.205;
} else if (yearlyCompensation < 140388) {
    taxRate = 0.265;
} else if (yearlyCompensation < 200000) {
    taxRate = 0.29;
} else {
    taxRate = 0.33;
}