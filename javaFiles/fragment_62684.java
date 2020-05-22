//Create MyAddress object that sets the address and name and then gets those values to     put into the list
MyAddress input = new MyAddress();
input.setName(name);
input.setAddress(address);

//Iterates through the list to add name and address values
for (int i = 0; i < addressBook.length; i++)
{
    if(addressBook[i] == null)
     {
        addressBook[i] = input;
        break;
     }
}