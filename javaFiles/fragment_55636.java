DefaultListModel mylistmodel = new DefaultListModel();
JList songs= new JList(mylistmodel );

Everytime you select a file, you can call add the item to the list by,

mylistmodel.addElement(songtoAdd); // songtoadd is an object

mylistmodel.insertElementAt(songtoAdd, 0); // to insert songs at specific positions.

mylistmodel.remove(IndexofSong);