String address = 
"Mr Moh Jo \n" + 
"Address \n" +
" 33333 City \n" +
"Aland Islands \n";

String [] addrLines = address.split("\n");
StringBuffer formatedAddress = new StringBuffer();

for(String line : addrLines)
{
    formatedAddress.append(line.trim()+ "\n");
}

System.out.println("formatedAddress: ");
System.out.println(formatedAddress.toString());