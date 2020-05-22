gremlin> g = new Neo4jGraph('/tmp/neo4j')
==>neo4jgraph[EmbeddedGraphDatabase [/tmp/neo4j]]
gremlin> g.addVertex([name:'stephen'])
==>v[0]
gremlin> g.V.map
==>{name=stephen}
gremlin> g.commit()
==>null
gremlin> g.shutdown()
==>null
gremlin> g = new Neo4jGraph('/tmp/neo4j')
==>neo4jgraph[EmbeddedGraphDatabase [/tmp/neo4j]]
gremlin> g.V.map                         
==>{name=stephen}