long size = ...;
int divisor = ...;
long fullResult = size / divisor;
if (fullResult < Integer.MIN_VALUE || fullResult > Integer.MAX_VALUE) {
    // Whatever, e.g. throw an exception
}
int result = (int) fullResult;