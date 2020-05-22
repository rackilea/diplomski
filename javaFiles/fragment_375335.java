Map<String, Object> parameters = new HashMap<String, Object>();

//if you want this to be compiled in runtime

JasperReport jasperReport = JasperCompileManager.compileReport(your JRXMLReport path file here);
JasperReport subReport = JasperCompileManager.compileReport(your JRXMLSubReport path file here);

//you can notice that there're a lot of overloaded mathods to compile it, you can choose
//what is better in your case

//if you want to use the complied file *.jasper
JasperReport jasperReport = (JasperReport)JRLoader.loadObject(new File("filenameReport.jasper"));

JasperReport subReport = (JasperReport)JRLoader.loadObject(new File("filenameSubReport.jasper"));


//Then you add your subReport in your parameter Map
parameters.put("SUBREPORT_JASPER_FILE", subReport);

JasperFillManager.fillReport(jasperReport, parameters,
                new JRBeanCollectionDataSource(yourList));