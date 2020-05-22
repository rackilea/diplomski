... ...

/**
 * Use the App Engine Java 7 runtime for this app.
 *
 * @parameter
 */
protected boolean useJava7;

... ...

if (useJava7) {
  arguments.add("--use_java7");
}

... ...