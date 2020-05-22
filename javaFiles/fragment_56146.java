JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(selectedDataList);
      parameters.put("ItemDataSource", beanColDataSource);

JRBeanCollectionDataSource chartColDataSource = new JRBeanCollectionDataSource(selectedDataList);

      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, chartColDataSource);