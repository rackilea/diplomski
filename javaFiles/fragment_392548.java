LinkedHashMap<String,String> hashMap = new LinkedHashMap<String,String>();  
hashMap.put("**EmptyValue**", "None");  
hashMap.put("-1", "Not Applicable");  

ComboBoxItem comboBoxItem = new ComboBoxItem();  
comboBoxItem.setName("filteredCombo");  
comboBoxItem.setTitle("Choose an item (ComboBox)");  
comboBoxItem.setAddUnknownValues(false);  
comboBoxItem.setOptionDataSource(ItemSupplyXmlDS.getInstance());  
comboBoxItem.setDisplayField("itemName");  
comboBoxItem.setValueField("itemID");  
comboBoxItem.setPickListWidth(300);  
comboBoxItem.setPickListFields(skuField, itemNameField);  
comboBoxItem.setSpecialValues(hashMap);  
comboBoxItem.setSeparateSpecialValues(true);