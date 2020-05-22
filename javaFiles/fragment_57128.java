JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        Map parameters = new HashMap();
        parameters.put("INFO", "Hello");
        parameters.put("DS1", beanColDataSource);

        JasperReport report = (JasperReport) JRLoader.loadObject("src/test/ireport/ShowPerson.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());