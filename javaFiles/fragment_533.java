project.getTasks().create("sourceJar", Jar.class, task -> {
    task.setClassifier("sources");
    // grab the convention that holds the sourceSets
    JavaPluginConvention javaConvention = project.getConvention().getPlugin(JavaPluginConvention.class);
    // find our source set
    SourceSet mainSourceSet = javaConvention.sourceSets.findByName('main');
    // user `from` like normal
    task.from(mainSourceSet.getAllSource());
});