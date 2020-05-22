private static void mainInputMenu() 
{ 

     Machine whichMachine = new Machine();

     int machineNumber = Machine.readInput();
     do
     {
        if (machineNumber == 1)    machineOne (machineNumber);
        else if (machineNumber == 2)    Machine machineTwo = new Machine();
        else if (machineNumber == 3)  System.exit(0);
        int machineNumber = Machine.readInput();
     }while (machineNumber > 0 && machineNumber < 4);


}