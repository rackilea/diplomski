/**
 * processes all the packages. Each invalid package found is sent to the given
 * invalid package handler.
 */ 
public void processPackages(InvalidPackageHandler invalidPackageHandler) {
    for (Package package: allPackages) {
        if (isInvalid(package)) {
            invalidPackageHandler.handle(package);
        }
        else {
            processPackage(package);
        }
    }
}