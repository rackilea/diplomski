try {
    java.util.Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(jTextFieldDate.getText());
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    rs.updateDate("", sqlDate);
} catch (ParseException ex) {
    Logger.getLogger(helpdesk.class.getName()).log(Level.SEVERE, null, ex);
}