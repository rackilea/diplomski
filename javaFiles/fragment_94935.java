...
@Inject Instance<IReport> availableReports;
...
@Produces
public IReport createReport() {
   IReport result;
   for (IReport report: availableReports) {
      // choose correct instance, you might want to query the injection
      // point or any attached qualifier a bit more in order to 
      // determine which is the correct instance
      if ...
         result = report;
      ...
   }
   return result;
}
...