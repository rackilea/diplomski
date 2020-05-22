List<File> files = new ArrayList<>();

//Add all XML Files containing a campaign root element into the files list
JAXBContext c = JAXBContext.newInstance(Campaign.class);
Unmarshaller u = c.createUnmarshaller();

//Declare list to store all of your camapaign object
List<Campaign> campaigns = new ArrayList<>();

for(File f : files)
{
    campaigns.add(u.unmarshall(f));
}

//display all campaigns
for(Campaign camp : campaigns){
    System.out.println(camp.getName());
    System.out.println(camp.getType());

    //Display all records
    for(Record rec : camp.getRecord()){
        System.out.println(rec);
    }
}