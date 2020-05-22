int index = 1;
for (Item item: items) {
   System.out.print(index + ". " + item.getName());
   if (item.getDescription() != null) {
     System.out.println(" (" + item.getDescription() + ")");
   } else {
     System.out.println"( (No Description Available)");
   }
   index++;
}    

List<NetworkInterface> nets = Collections.list(NetworkInterface.getNetworkInterfaces());
if (nets.size() == 0) {
  System.out.println();
  System.out.println("No interfaces found! Make sure WinPcap is installed.");
  return;
}

System.out.print("Enter the interface number(1-" + nets.size() + "):");
Byte[] input = new byte[100];
System.in.read(input);
String inString = new String(input);
int interfaceIndex = Integer.getInteger(inString);

if (interfaceIndex < 1 || interfaceindex > nets.size()) {
   System.out.println();
   System.out.println("Interface number out of range.");
   // freeing items is done by dereferencing
   nets = null;
   return;
} 

// jump to the selected adapter
NetworkInterface selectedInterface = nets.get(interfaceIndex);