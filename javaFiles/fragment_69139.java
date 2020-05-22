ArtifactFilter artifactFilter = createResolvingArtifactFilter();
rootNode = dependencyTreeBuilder.buildDependencyTree( project,
        localRepository, artifactFactory, artifactMetadataSource,
        artifactFilter, artifactCollector );
String dependencyTreeString = serializeDependencyTree( rootNode );
DependencyUtil.log( dependencyTreeString, getLog() );