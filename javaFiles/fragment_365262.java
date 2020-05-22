...
List<Parent> parent = //method for getting datasource
List<String> testStrings = getTestStrings(parent);
...
//pass the list of testStrings to the report
//inside the report, create a parameter of type List
//pass list.get($V{ctr}) to the subreport where ctr is the current count of the subreport, make it start with 0