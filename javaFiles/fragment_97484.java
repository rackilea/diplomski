Reports reports = document.getReports();
Report report = reports.getItem(0);
// Gets the drill info
DrillInfo drillInfo = (DrillInfo) report.getNamedInterface("DrillInfo");
DrillBar drillBar = null;
try {
     drillBar = drillInfo.getDrillBar();
} catch (Exception e) {
    // it may fails if you have prompt to answer for example.
}
if (drillBar != null) {
    // drillBar.getCount();  // to have the number of filters
    DrillBarObject drillBarObject = drillBar.getItem(0);
    System.out.println(drillBarObject.getName()); // Print the filter abject name

    // Print the filter value / if it is an empty string, it means "AllValues"
    System.out.println(drillBarObject.getFilter()); 
}