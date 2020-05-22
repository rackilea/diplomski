Alpr alpr = new Alpr("us", "/path/to/openalpr.conf", "/path/to/runtime_data");

// Set top N candidates returned to 20
alpr.setTopN(20);

// Set pattern to Maryland
alpr.setDefaultRegion("md");

AlprResults results = alpr.recognize("/path/to/image.jpg");
System.out.format("  %-15s%-8s\n", "Plate Number", "Confidence");
for (AlprPlateResult result : results.getPlates())
{
    for (AlprPlate plate : result.getTopNPlates()) {
        if (plate.isMatchesTemplate())
            System.out.print("  * ");
        else
            System.out.print("  - ");
        System.out.format("%-15s%-8f\n", plate.getCharacters(), plate.getOverallConfidence());
    }
}