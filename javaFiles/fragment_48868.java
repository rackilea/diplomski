HashSet<String> all = new HashSet<String>();
// then populate all with your 5 station strings (loop)
HashSet<String> have = new HashSet<String>();
// then populate all with the contents of your table (loop)
all.removeAll(have);
// all now contains the ones that weren't in the table.