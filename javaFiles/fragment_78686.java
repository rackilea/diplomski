rule "Scientific Name"
when 
    dwc : MyDwcClass( scientificName != null )
then
    System.out.println(dwc);
end