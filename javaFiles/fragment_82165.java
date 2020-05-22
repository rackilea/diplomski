public void getSecondReport() {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            faces.getExternalContext().responseReset();
            this.prAuditCompareModelBean.getLatestReport();
            faces.responseComplete();
        } catch (Exception e) {
            PODBException.wrap(e, PODBExceptionInformation.create(
                    PODBExceptionType.ERROR,
                    ProductRuleAuditCompareBackingBean.class.getName(),
                    "getting first report",
                    "Error while getting second report for download", "1"));
        } 

    }