for( KnowledgePackage kpkg : kbuilder.getKnowledgePackages() ) {
    // need to clone the rule references for iteration
    Collection<Rule> rules = new ArrayList<Rule>( kpkg.getRules() );
    for( Rule rule : rules ) {
        if( ! RULE_YOU_WANT.equals( rule.getName() ) ) {
            // NOT recommended as you are using internal APIs
            ((KnowledgePackageImp)kpkg).removeRule( rule );
        }
    }
}