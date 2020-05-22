// find out if person has good IQ and is patient, but not strong
int mask = 0;
mask |= (1<<0);  // set bit 0 (good IQ)
mask |= (1<<2);  // set bit 2 (patient)
if (personsMask & mask == mask) {
    // you know the person has a good IQ and is patient, but they are `not` strong
}