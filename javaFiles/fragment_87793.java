Class<?> cls = Class.forName(reportDefs.getReportImplementationClass());
Object obj = null;

// get the constructors
Constructor<?>[] allConstructors = cls.getDeclaredConstructors();

// must have at least one constructor
if ((allConstructors.length <= 2) && (allConstructors.length > 0)) { 
    for (Constructor<?> constructor : allConstructors) {
        Class<?>[] pType = constructor.getParameterTypes();

        if (pType.length >= 1) { // grab the non empty constructor

            Object[] objParamsObjects = new Object[pType.length];

            for (int i = 0; i < pType.length; i++) {
                objParamsObjects[i] = injector.getInstance(pType[i]);
            }

            obj = constructor.newInstance(objParamsObjects);
            break;
        }
    }

    // constructor with no parameters
    if (obj == null) {
        obj = cls.newInstance();
    }

    ReportDataCollector reportObj = (ReportDataCollector) obj;

    birtGroupList = reportObj.getReportData(reportRequest, emProvider);

    if (birtGroupList != null) {
        result = runner.runReport(birtGroupList, reportRequest);
    }
}