numGrammars = Integer.parseInt(fin.nextLine());
System.out.println("Num Grammars:" + numGrammars);


for(int v=0; v < numGrammars; v++){
   int numVariables = Integer.parseInt(fin.nextLine());
   System.out.printf("numVariables: %s", numVariables);

    for(int z=0; z < numVariables; z++){
        //reads in variable line
        String line = fin.nextLine();
        String[] strings = line.split(" ");

        for(int m=0; m < strings.length; m++){
           int numRules = Integer.parseInt(strings[0]);
           //All other array slots in strings array should be groups of letters on group per slot...

        }   
    }
}