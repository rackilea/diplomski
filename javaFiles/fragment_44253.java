for(int i = 0; i < vehicles.length; i++)
{
    if(vehicles[i] == null)
    {
        Scanner reader = new Scanner(file);
        Honda[i] = new Vehicle();
        Honda[i].readRecord(reader);
        vehicles[i] = Honda[i];
        reader.close();
        break; //break out of the loop
    }
}