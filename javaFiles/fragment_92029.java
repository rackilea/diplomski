List<BuildStepDescriptor<? extends Builder>> builders = new ArrayList<BuildStepDescriptor<? extends Builder>>();
for ( hudson.model.Descriptor<Builder> descriptor : Builder.all() ) {
    if ( !( descriptor instanceof BuildStepDescriptor ) ) {
        continue;
    }
    BuildStepDescriptor<? extends Builder> buildStepDescriptor = (BuildStepDescriptor) descriptor;
    // newJob is a FreeStyleProject
    if ( buildStepDescriptor.isApplicable( newJob.getClass() ) && hasDbc( buildStepDescriptor.clazz ) ) {
        builders.add( buildStepDescriptor );
    }
}
for ( BuildStepDescriptor<? extends Builder> buildStepDescriptor : builders ) {
    System.out.println( buildStepDescriptor.getDisplayName() );
}

private boolean hasDbc( final Class<?> clazz ) {
    for ( Constructor<?> constructor : clazz.getConstructors() ) {
        if ( constructor.isAnnotationPresent( DataBoundConstructor.class ) ) {
            return true;
        }
    }
    return false;
}