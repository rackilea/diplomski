public void setControl(String value, Group templateTypeGroup) {
    Object grd = null;
    Point pt = null;
    Rectangle rct = null;   
    if(TableTemplateConfigConstants.dateItems.contains(value) && null != defaultValueText){
        grd = defaultValueText.getLayoutData();
        pt = defaultValueText.getLocation();
        rct = defaultValueText.getBounds();
        defaultValueText.dispose();
        cleanControls();
        createDateControl(templateTypeGroup,grd,pt,rct,value);}}


public void createDateControl(Composite templateTypeGroup, Object data, Point pt, Rectangle rectangle,String value){
    **enumDateChooser = new DateChooserCombo(
            templateTypeGroup, SWT.BORDER | CDT.DROP_DOWN
                    | CDT.DATE_SHORT);
    enumDateChooser.setFormatter(new DateFormatter(
            ITableDataConstants.DATE_FORMAT_TABLE_VIEWER));     
    enumDateChooser.setLayoutData((GridData)data);
    if(null != pt && null != rectangle){
        enumDateChooser.setLocation(pt);
        enumDateChooser.setBounds(rectangle);
    }
    enumDateChooser.setLocation(pt)**
    try {
    if(!isEdit){    


        if (TableTemplateConfigConstants.endDateLst.contains(value)) {
            enumDateChooser
                    .setValue(checkFormat(TableTemplateConfigConstants.endDate));
            DateFormat formatter = new SimpleDateFormat(TableTemplateConfigConstants.DATE_FORMAT_TABLE_VIEWER); 
            setDefaultVal(formatter.format(checkFormat(enumDateChooser.getText())));
        } else if (TableTemplateConfigConstants.effectiveDate
                .contains(value)) {
            enumDateChooser.setValue(new Date());
            DateFormat formatter = new SimpleDateFormat(TableTemplateConfigConstants.DATE_FORMAT_TABLE_VIEWER); 
            setDefaultVal(formatter.format(checkFormat(enumDateChooser.getText())));
        } else if (null != getDefaultVal() && !getDefaultVal().isEmpty()) {
            enumDateChooser.setValue(checkFormat(getDefaultVal()));
            setDefaultVal(value);
        }
    }else{
        enumDateChooser
        .setValue(checkFormat(getDefaultVal()));
    }
    } catch (ParseException e1) {
        PALogger.logError("Unable to parse date",
                PAEventCategory.OTHERS, Activator.PLUGIN_ID,e1);
    }

    setDateDecoration(false);
    enumDateChooser.addModifyListener(new ModifyListener() {

        @Override
        public void modifyText(ModifyEvent e) {             
            System.out.println(enumDateChooser.getText());
            if (null != enumDateChooser && !enumDateChooser.isDisposed()
                    ) {
                setDateDecoration(true);
            }
            setDateCheckBoxes();
        }
    });
}