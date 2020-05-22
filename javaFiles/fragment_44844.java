ArrayList<customtype> dir = new ArrayList<customtype>();
ArrayList<String> listing = new ArrayList<String>();
    customtype item;
    for(int i=0;i<dir.size();i++)
    {
        item = dir.get(i);
        listing.add(item.getPath()); 
    //getPath is a method in the customtype class which will return value in string format

      }
final CharSequence[] fol_list = listing.toArray(new CharSequence[listing.size()]);
//fol_list will have all the strings from getPath();