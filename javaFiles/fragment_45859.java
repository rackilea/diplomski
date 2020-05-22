static int convert(const float temp1, const float temp2, const float temp3) {
    unsigned int c;

    if ( (temp3 * 6) < 1) c = (unsigned int) ((temp2 + (temp1 - temp2) * 6 * temp3) * 100);
    else if ((temp3 * 2) < 1) c = (unsigned int) (temp1 * 100);
    else if ((temp3 * 3) < 2) c = (unsigned int) ((temp2 + (temp1 - temp2) * (.66666 - temp3) * 6) * 100);
    else c = (unsigned int) (temp2 * 100);

    return c;
}