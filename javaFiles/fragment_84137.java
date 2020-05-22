boolean matched;
for (int iter = 0; iter < a; iter++) {
    if ((i + iter) % 25 == 0) {
        matched = true;
        break;
    }
}
if (matched) {
    //...
}