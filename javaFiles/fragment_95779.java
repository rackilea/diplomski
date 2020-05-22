%# example Object[] array
my_array = javaArray('java.lang.Object', 5);
for i=1:5, my_array(i) = java.lang.Double(i); end

%# convert to MATLAB vector
M = arrayfun(@(x)x, my_array);

%# or equivalently
M = cell2mat( cell(my_array) );

>> whos M
  Name      Size            Bytes  Class     Attributes

  M         5x1                40  double