inject('Org','Asset','Class').flatMap{
  g.V().has(it.get(),'name', 'theNameYouArSearchingFor')
}.
choose(label()).
  option('Org',   someTraversalForOrg()).
  option('Asset', someTraversalForAsset()).
  option('Class', someTraversalForClass())