long weightALong = Double.doubleToRawLongBits(weightA);
long weightBLong = Double.doubleToRawLongBits(weightB);
long mask = -1L; // all bits set to 1
int crossOverPoint = randInt(0, Long.SIZE);
long combined;
// treat special cases because of modulo Long.SIZE of second parameter of shifting operations
if (crossOverPoint == 0) {
    combined = weightBLong;
} else if (combined == Long.SIZE) {
    combined = weightALong;
} else {
    combined = (weightALong & (mask << (Long.SIZE - crossOverPoint))) |
               (weightBLong & (mask >>> crossOverPoint));
}
double newWeight = Double.longBitsToDouble(combined);