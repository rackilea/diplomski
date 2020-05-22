class ZipRange {
    int start;
    int end;
}

// Fill up this map parsing through csv
Map<ZipRange, Integer> zipToRegion;

int zipToSearch = 2870;

// Create method which returns integer which corresponds to region
for (ZipRange zip : zipToRegion.keySet()) {
    if (zipToSearch >= zip.start && zipToSearch <= zip.end) {
        return zipToRegion.get(zip);
    }
}
return -1;