$ ../bin/ij
ij version 10.4
ij> connect 'jdbc:derby:testdb;create=true;dataEncryption=true;encryptionAlgorithm=Blowfish/ECB/NoPadding;bootPassword=$ecureC@deCanBr@kE0074242';
ij> quit;
$ sed -i .o 's/Blowfish/DES/' testdb/service.properties 
$ ../bin/ij
ij version 10.4
ij> connect 'jdbc:derby:testdb;bootPassword=$ecureC@deCanBr@kE0074242';
ERROR XJ040: Failed to start database 'testdb', see the next exception for details.
ERROR XBM06: Startup failed. An encrypted database cannot be accessed without the correct boot password.  
ij> quit;
$ sed -i .o 's/DES/Blowfish/' testdb/service.properties 
$ ../bin/ij
ij version 10.4
ij> connect 'jdbc:derby:testdb;bootPassword=$ecureC@deCanBr@kE0074242';
ij> quit;
$