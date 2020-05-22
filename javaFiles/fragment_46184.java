public void LookupInsert(int invoiceNumber)
{
    Properties props = System.getProperties();
    //if there is no invoice number in properties file then get(invoiceNumber) will be null
    if(props.get(invoiceNumber)== null)
        props.setProperty(new Integer(invoiceNumber).toString(), new Integer(1).toString());
    else
    {
        int value = Integer.parseInt(props.get(invoiceNumber).toString());
        value++;
        props.setProperty(new Integer(invoiceNumber).toString(), new Integer(value).toString());
    }
File file =new File("test.properties");
FileWriter fw = new FileWriter(file);
props.store(fw,"");
fw.close();
}