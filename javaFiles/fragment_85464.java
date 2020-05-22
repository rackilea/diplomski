// Get an RDFS reasoner
GenericRuleReasoner rdfsReasoner = (GenericRuleReasoner) ReasonerRegistry.getRDFSReasoner();
// Steal its rules, and add one of our own, and create a
// reasoner with these rules
List<Rule> customRules = new ArrayList<>( rdfsReasoner.getRules() );
String customRule = "[rule1: (?a eg:p ?b) (?b eg:p ?c) -> (?a eg:p ?c)]";
customRules.add( Rule.parseRule( customRule ));
Reasoner reasoner = new GenericRuleReasoner( customRules );