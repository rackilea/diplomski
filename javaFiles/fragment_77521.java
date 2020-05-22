JasperDesign design = JRXmlLoader.load(stream); //Location of jrxml file example FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/rep‌​orts/" + "myReport"+".jrxml");
design.setBottomMargin(bottomMargin); //set the margins
design.setTopMargin(topMargin)
design.setLeftMargin(leftMargin)
design.setRightMargin(rightMargin);
design.setColumnWidth(design.getPageWidth()-leftMargin-rightMargin);//if you change your left and right margin you need to set new correct columnWidth

//compile the report
JasperReport report = JasperCompileManager.compileReport(design); //this is what you called template