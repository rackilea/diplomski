/**
 * processes all the packages and returns the invalid ones
 */ 
public List<Package> processPackages() {
    List<Package> invalidPackages = new ArrayList<>();
    for (Package package: allPackages) {
        if (isInvalid(package)) {
            invalidPackages.add(package);
        }
        else {
            processPackage(package);
        }
    }
    return invalidPackages;
}