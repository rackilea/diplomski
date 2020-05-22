MyModel cusModel = (MyModel) getCurrentRowObject();
    StringBuffer buf = new StringBuffer();

    String customerName=cusModel.getName();

    if (customerName.indexOf('\'') >= 0){
        customerName=StringEscapeUtils.escapeJavaScript(customerName);          
    } else {
        customerName=StringEscapeUtils.escapeHtml(customerName);            
    }

    cusModel.setName(customerName);