STEP-BY-STEP GUIDE
1. As SYS, confirm the JVM is not already installed. 

    SELECT comp_id, comp_name FROM dba_registry; 

should not list JAVAM or CATJAVA.

2. As SYS, perform the JVM installation. 

@?/javavm/install/initjvm.sql

@?/rdbms/admin/catjava.sql

3. As SYS, confirm the JVM is now fully installed:

    SELECT comp_id, comp_name FROM dba_registry;


    COMP_ID    COMP_NAME
    ---------  --------------------------------------------
    EM         Oracle Enterprise Manager
    CATALOG    Oracle Database Catalog Views
    CATPROC    Oracle Database Packages and Types
    JAVAVM     JServer JAVA Virtual Machine
    CATJAVA    Oracle Database Java Packages