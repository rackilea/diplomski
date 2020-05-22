struk=new ArrayList<ListTrxPrint>();
for (int i = 0; i < model.getRowCount(); i++) {
   Boolean value = (Boolean) model.getValueAt(i, 11);// check state
   if (value) {
       ListTrxPrint trx=new ListTrxPrint();
       trx.setId(model.getValueAt(i, 0).toString());
       trx.setMsisdn(model.getValueAt(i, 4).toString());
       trx.setExecute_date(model.getValueAt(i, 3).toString());
       trx.setNominal(model.getValueAt(i, 6).toString());
       trx.setSales_price(model.getValueAt(i,7).toString());
       trx.setUser_name(model.getValueAt(i, 1).toString());
       struk.add(trx);
   }
 }      
 bean=new JRBeanCollectionDataSource(struk);