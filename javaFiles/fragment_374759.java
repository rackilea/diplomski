Set<String> set1 = new HashSet<String>(FileUtils.readLines(file1));

Set<String> set2 = new HashSet<String>(FileUtils.readLines(file2));


Set<String> similars = new HashSet<String>(set1);

similars.retainAll(set2);

set1.removeAll(similars); //now set1 contains distinct lines in file1
set2.removeAll(similars); //now set2 contains distinct lines in file2
System.out.println(set1); //prints distinct lines in file1;
System.out.println(set2); //prints distinct lines in file2