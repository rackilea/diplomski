private BusinessObject businessObject;

public void setBusinessObject(BusinessObject instance) {
    businessObject = instance;
}

private BusinessObject getBusinessObject() {
    if (businessObject == null) {
        // represents existing implementation in original code sample
        businessObject = BusinessObjectGenerator.getBusinessObject();
    }
    return businessObject;
}

/* rest of your code */