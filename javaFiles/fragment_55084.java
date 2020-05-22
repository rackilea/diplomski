case 1:
  for(int i=0; i<a.length; i++){

System.out.print("Enter Model: ");
Model = read.next();
System.out.print("Enter Plate Number: ");
PlateNo = read.next();
System.out.print("Enter Manufactured Year: ");
ManufacturedYear = read.nextInt();
System.out.print("Enter Transmission Type: ");   
TransmissionType = read.next();
System.out.print("Enter Color: "); 
Color = read.next();

CarList used = new CarList(Model, PlateNo, ManufacturedYear,
       TransmissionType, Color);
a[i] = used;
        return;
}
break;

...keep on going....