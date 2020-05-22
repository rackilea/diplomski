FormPanel form = new FormPanel();
form.setEncoding(FormPanel.ENCODING_URLENCODED); // use urlencoded
form.setMethod(FormPanel.METHOD_GET);
FlowPanel fields = new FlowPanel(); // FormPanel only accept one widget
fields.add(new Hidden("entityId", "101")); // add it as hidden
form.setWidget(fields); 
form.setAction(GWT.getModuleBaseURL() + "downloadfile");
form.submit(); // then the browser will add it as query param!