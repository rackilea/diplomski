// Holds the Current Page Index, value picked from JSP(Front End)
private String pageIndex = "0";
// Holds the Wizard Page which is set in the xxx-validation.xml
private String wizardPage = "0";
// Holds a Value  by which I can identify if the action is back button click
//If true validation is ignored. This is also taken from the JSP(Front End)
private String backClicked;

public String getBackClicked() {
    return backClicked;
}

public void setBackClicked(String backClicked) {
    this.backClicked = backClicked;
}

public String getPageIndex() {
    return pageIndex;
}

public void setPageIndex(String pageIndex) {
    this.pageIndex = pageIndex;
}

public String getWizardPage() {
    return wizardPage;
}

public void setWizardPage(String wizardPage) {
    this.wizardPage = wizardPage;
}

@Override
public void validate(Object object) throws ValidationException {
    final String fieldName = getFieldName();
    final Object value = getFieldValue(fieldName, object);
    if(!"0".equals(pageIndex)){
        Integer pageIndexValue = (Integer) getFieldValue(pageIndex, object);
        if (pageIndexValue != null) {
            backClicked = (String) getFieldValue(backClicked, object);
            if(StringUtils.isNotBlank(backClicked) && Boolean.valueOf(backClicked)){
                pageIndexValue = pageIndexValue - 1;
            }
            pageIndex = String.valueOf(pageIndexValue);
        }
    }
    if(wizardPage.equals(pageIndex)) {
        if (!(value instanceof String)) {
            addFieldError(fieldName, object);
            return;
        }
        String strValue = (String) value;
        if (StringUtils.isBlank(strValue)) {
            addFieldError(fieldName, object);
        }
    }
}