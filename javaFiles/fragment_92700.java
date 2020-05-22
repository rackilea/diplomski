case 0:
String accnum,pin,name;

System.out.print("Enter account name: ");
name = input.nextLine();

System.out.print("Enter account number: ");
accnum = input.nextLine();

System.out.print("Enter account PIN: ");
pin = input.nextLine();

atm.set_accinfos(name,accnum,pin);
//System.out.print(atm.return_acc() + "\t" + atm.return_pin() + "\n");
break;