int max = 1;
PhoneRecord[] records = new PhoneRecord[max];
int numRecords = 0;

void addRecord(PhoneRecord rec) {
    records[numRecords++] = rec;
    if(numRecords == max) {
        /* out of space, double the array size */
        max *= 2;
        records = Arrays.copyOf(records, max);
    }
}