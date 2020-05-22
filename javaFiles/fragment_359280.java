$ mvn archetype:create -DgroupId=com.mycompany.samples -DartifactId=cobertura-haltonfailure-testcase
...
$ mvn clean install
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Building cobertura-haltonfailure-testcase
[INFO]    task-segment: [clean, install]
[INFO] ------------------------------------------------------------------------
[INFO] [clean:clean {execution: default-clean}]
[INFO] Deleting directory /home/pascal/Projects/cobertura-haltonfailure-testcase/target
[INFO] [resources:resources {execution: default-resources}]
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/pascal/Projects/cobertura-haltonfailure-testcase/src/main/resources
[INFO] [compiler:compile {execution: default-compile}]
[INFO] Compiling 1 source file to /home/pascal/Projects/cobertura-haltonfailure-testcase/target/classes
[INFO] [resources:testResources {execution: default-testResources}]
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/pascal/Projects/cobertura-haltonfailure-testcase/src/test/resources
[INFO] [compiler:testCompile {execution: default-testCompile}]
[INFO] Compiling 1 source file to /home/pascal/Projects/cobertura-haltonfailure-testcase/target/test-classes
[INFO] [surefire:test {execution: default-test}]
[INFO] Surefire report directory: /home/pascal/Projects/cobertura-haltonfailure-testcase/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.mycompany.samples.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.09 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] [jar:jar {execution: default-jar}]
[INFO] Building jar: /home/pascal/Projects/cobertura-haltonfailure-testcase/target/cobertura-haltonfailure-testcase-1.0-SNAPSHOT.jar
[INFO] Preparing cobertura:check
[WARNING] Removing: check from forked lifecycle, to prevent recursive invocation.
[INFO] [resources:resources {execution: default-resources}]
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/pascal/Projects/cobertura-haltonfailure-testcase/src/main/resources
[INFO] [compiler:compile {execution: default-compile}]
[INFO] Nothing to compile - all classes are up to date
[INFO] [cobertura:instrument {execution: default}]
[INFO] Cobertura 1.9.2 - GNU GPL License (NO WARRANTY) - See COPYRIGHT file
Instrumenting 1 file to /home/pascal/Projects/cobertura-haltonfailure-testcase/target/generated-classes/cobertura
Cobertura: Saved information on 1 classes.
Instrument time: 337ms

[INFO] Instrumentation was successful.
[INFO] [resources:testResources {execution: default-testResources}]
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/pascal/Projects/cobertura-haltonfailure-testcase/src/test/resources
[INFO] [compiler:testCompile {execution: default-testCompile}]
[INFO] Nothing to compile - all classes are up to date
[INFO] [surefire:test {execution: default-test}]
[INFO] Surefire report directory: /home/pascal/Projects/cobertura-haltonfailure-testcase/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.mycompany.samples.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.098 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] [cobertura:check {execution: default}]
[INFO] Cobertura 1.9.2 - GNU GPL License (NO WARRANTY) - See COPYRIGHT file
Cobertura: Loaded information on 1 classes.

[ERROR] com.mycompany.samples.App failed check. Line coverage rate of 0.0% is below 80.0%
Project failed check. Total line coverage rate of 0.0% is below 90.0%

[INFO] ------------------------------------------------------------------------
[ERROR] BUILD ERROR
[INFO] ------------------------------------------------------------------------
[INFO] Coverage check failed. See messages above.
[INFO] ------------------------------------------------------------------------
[INFO] For more information, run Maven with the -e switch
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 18 seconds
[INFO] Finished at: Sat Oct 24 21:00:39 CEST 2009
[INFO] Final Memory: 17M/70M
[INFO] ------------------------------------------------------------------------
$