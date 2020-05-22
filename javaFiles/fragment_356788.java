# wrong, FQN is needed
java Foon

# wrong, there is no `com/acme/example` folder in the current working directory
java com.acme.example.Foon

# wrong, similar to above
java -classpath . com.acme.example.Foon

# fine; relative classpath set
java -classpath ../../.. com.acme.example.Foon

# fine; absolute classpath set
java -classpath /usr/local/acme/classes com.acme.example.Foon