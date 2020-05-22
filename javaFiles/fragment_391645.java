/**
 * processes all the packages
 * @throws InvalidPackagesFoundException if invalid packages were found. The thrown
 *         exception contains the invalid packages
 */ 
public void processPackages() throws InvalidPackagesFoundException{
    List<Package> invalidPackages = new ArrayList<>();
    for (Package package: allPackages) {
        if (isInvalid(package)) {
            invalidPackages.add(package);
        }
        else {
            processPackage(package);
        }
    }
    if (!invalidPackages.isEmpty()) {
        throw new InvalidPackagesFoundException(invalidPackages);
    }
}