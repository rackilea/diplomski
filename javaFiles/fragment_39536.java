incoterm.setKey("address1_freighttermscode")   
//assuming the arg is an integer value that matches a picklist value for the attribute    
OptionSetValue freight = new OptionSetValue();
freight.Value = args[13];
incoterm.setValue(freight);    
collection.addKeyValuePairOfstringanyType(incoterm);