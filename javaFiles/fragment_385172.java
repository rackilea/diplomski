// contains method must be reflexive
Assert.isLegal(rule.contains(rule));

// contains method must return false when given an unknown rule
Assert.isLegal(!rule.contains(nullRule));

// isConflicting method must be reflexive
Assert.isLegal(rule.isConflicting(rule));

// isConflicting method must return false when given an unknown rule
Assert.isLegal(!rule.isConflicting(nullRule));