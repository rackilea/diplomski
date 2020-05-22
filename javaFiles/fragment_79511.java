Car[] cars = new Car[4];

while (inputFile.hasNext())
{
    String filecotent = inputFile.nextLine();

    String[] tokens = filecotent.split(" ");

    if(filecotent.startsWith("CarInLot")){
        cars[0].setRegion(tokens[2]);
        cars[0].setMinutes(Integer.parseInt(tokens[4]));
    }
    ...