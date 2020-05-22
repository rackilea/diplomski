//Create the virtualizer after 2 pages filled save in tmp director
JRFileVirtualizer virtualizer = new JRFileVirtualizer(2, "tmp");

//Preparing parameters
Map parameters = new HashMap();
parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);