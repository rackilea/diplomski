...

else if ((max1 == max2 && max2 == max3 && max1 == max3) && x[i] < max2) {
    max2 = x[i];
    if (max2 < max3) {
        max3 = max2;
    }
} else if (max2 == max3 && x[i] < max3) {
    max3 = x[i];
}

...