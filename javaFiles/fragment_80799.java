final String delimiterManuals = ";;;;;;;;";
    final String delimiterValues = "::::::::";

//save file
for (int i1 = 0; i1 < Library.ManualList.size() - 1; i1++)
{
    //here are all attributes
    pw.print(Library.ManualList.get(i1).title));
    pw.print(delimiterValues);
    pw.print(Library.ManualList.get(i1).author));
    pw.print(delimiterValues);
    pw.print(Library.ManualList.get(i1).publicationYear));
    pw.print(delimiterValues);
    pw.print(Library.ManualList.get(i1).status));
    pw.print(delimiterValues);
    pw.print(Library.ManualList.get(i1).borrower));
    pw.print(delimiterValues);
    pw.print(Library.ManualList.get(i1).borrowDate));
    pw.print(delimiterValues);
    pw.print(Library.ManualList.get(i1).returnDate); //this is your last attribute
    pw.print(delimiterManuals);
}
//WATCH: lastAttribute is just an example (because I don't want to write every attribute)
//last Manual has no delimiterManual at the end (end of file)
pw.print(Library.ManualList.get(Library.ManualList.size()-1).title));
pw.print(delimiterValues);
pw.print(Library.ManualList.get(Library.ManualList.size()-1).author));
pw.print(delimiterValues);
//other attributes of the manual...
pw.print(Library.ManualList.get(Library.ManualList.size()-1).lastAttribute);


ArrayList<String> a = new ArrayList<String>();
//load
FileReader fr = new FileReader("Library.txt");
BufferedReader br = new BufferedReader(fr);

String str;
while ((str = br.readLine()) != null)
{
    a.add(str);
}
ArrayList<Manual> manuals = new ArrayList<Manual>()
for(int i = 0; i < a.size(); ++i)
{
    //split into single manuals
    String[] split1 = a.get(i).split(delimiterManuals);
    for(int j = 0; j < split1.length; ++j)
    {
        //split into single values
        String[] split2 = split1.split(delimiterValues);
        //here you have all values of a manual in the order you saved them so:
        Manual m = new Manual();
        m.title = split[0]; // <-- please don't do this! create and use setter/getter (like m.setTitle(split[0]);
        m.author = split[1]
        // till all fields are filled up
        manuals.add(m);
    }
}

//now you have all manuals in the manuals ArrayList