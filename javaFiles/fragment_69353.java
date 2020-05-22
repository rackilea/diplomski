File file=new File("demo.jrxml");
        InputStream stream=new FileInputStream(file);
        JasperDesign design=JRXmlLoader.load(stream);
        JasperReport report=JasperCompileManager.compileReport(design);

        Map<String, Object> params=new HashMap<String, Object>();
        params.put("param1", "data1"); // note here you can add parameters which would be utilized by the report

        JasperPrint print=JasperFillManager.fillReport(report, params,new JREmptyDataSource());
        //use JasperExportManager to export report to your desired requirement