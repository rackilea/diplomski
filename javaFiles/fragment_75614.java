input = new Scanner(new File("Sales.txt"));
int i = 0,
while (input.hasNextLine()) 
        fileinput[i] = input.nextLine();
        System.out.println(fileinput[i]);
        i++;
}