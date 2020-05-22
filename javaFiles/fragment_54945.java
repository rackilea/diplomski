// load package
KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
kbuilder.add( ResourceFactory.newUrlResource( "http://localhost:8080/guvnor-5.4.0.Final-jboss-as-7.0/org.drools.guvnor.Guvnor/package/some.pkg/LATEST" ), 
              ResourceType.PKG );

// create the knowledge base
KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();

// add the package to the kbase
kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );