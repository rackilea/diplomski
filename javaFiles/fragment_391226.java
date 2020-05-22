try {

    String shopName = jComboBox1.getSelectedItem().toString();
    String actionCode = jComboBox2.getSelectedItem().toString();

    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("storeName", shopName);
    map.put("actionCode", actionCode);

    URL reportFileURL = getClass().getResource("../ireps/AccessCounter.jrxml");
    File reportFile = new File(reportFileURL.toURI());
    JasperDesign jasperDesign = JRXmlLoader.load(reportFile);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

    JasperViewer jv = new JasperViewer(jasperPrint);
    JDialog viewer = new JDialog(this, "Batch Report", true);
    viewer.setBounds(jv.getBounds());
    viewer.getContentPane().add(jv.getContentPane());
    viewer.setResizable(true);
    viewer.setIconImage(jv.getIconImage());
    viewer.setVisible(true);

} catch (JRException exc) {
   System.out.println(exc.getMessage());
} catch (URISyntaxException exs) {
   System.out.println(exs.getMessage());
}