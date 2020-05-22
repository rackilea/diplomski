$ ant 
Buildfile: /home/mark/Files/Dev/ivy/demo/build.xml

resolve:
[ivy:resolve] :: Apache Ivy 2.3.0 - 20130110142753 :: http://ant.apache.org/ivy/ ::
[ivy:resolve] :: loading settings :: url = jar:file:/home/mark/.ant/lib/ivy.jar!/org/apache/ivy/core/settings/ivysettings.xml
[ivy:resolve] :: resolving dependencies :: com.myspotontheweb#demo;working@mark-Lemur-Ultra
[ivy:resolve]   confs: [compile, runtime, test]
[ivy:resolve]   found org.slf4j#slf4j-api;1.7.5 in public
[ivy:resolve]   found org.slf4j#slf4j-log4j12;1.7.5 in public
[ivy:resolve]   found log4j#log4j;1.2.17 in public
[ivy:resolve]   found junit#junit;4.11 in public
[ivy:resolve]   found org.hamcrest#hamcrest-core;1.3 in public
[ivy:resolve] :: resolution report :: resolve 347ms :: artifacts dl 14ms
    ---------------------------------------------------------------------
    |                  |            modules            ||   artifacts   |
    |       conf       | number| search|dwnlded|evicted|| number|dwnlded|
    ---------------------------------------------------------------------
    |      compile     |   1   |   0   |   0   |   0   ||   1   |   0   |
    |      runtime     |   3   |   0   |   0   |   0   ||   3   |   0   |
    |       test       |   5   |   0   |   0   |   0   ||   5   |   0   |
    ---------------------------------------------------------------------
[ivy:report] Processing /home/mark/.ivy2/cache/com.myspotontheweb-demo-compile.xml to /home/mark/Files/Dev/ivy/demo/build/ivy-reports/com.myspotontheweb-demo-compile.html
[ivy:report] Processing /home/mark/.ivy2/cache/com.myspotontheweb-demo-runtime.xml to /home/mark/Files/Dev/ivy/demo/build/ivy-reports/com.myspotontheweb-demo-runtime.html
[ivy:report] Processing /home/mark/.ivy2/cache/com.myspotontheweb-demo-test.xml to /home/mark/Files/Dev/ivy/demo/build/ivy-reports/com.myspotontheweb-demo-test.html

resources:
     [copy] Copying 1 file to /home/mark/Files/Dev/ivy/demo/build/classes

compile:
    [javac] Compiling 1 source file to /home/mark/Files/Dev/ivy/demo/build/classes

compile-tests:
    [mkdir] Created dir: /home/mark/Files/Dev/ivy/demo/build/test-classes
    [javac] Compiling 1 source file to /home/mark/Files/Dev/ivy/demo/build/test-classes

test:
    [mkdir] Created dir: /home/mark/Files/Dev/ivy/demo/build/test-reports
    [junit] Running org.demo.AppTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Time elapsed: 0.085 sec

build:
[ivy:retrieve] :: retrieving :: com.myspotontheweb#demo
[ivy:retrieve]  confs: [runtime]
[ivy:retrieve]  3 artifacts copied, 0 already retrieved (512kB/16ms)
      [jar] Building jar: /home/mark/Files/Dev/ivy/demo/build/dist/demo.jar

BUILD SUCCESSFUL
Total time: 4 seconds