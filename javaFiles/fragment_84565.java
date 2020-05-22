gremlin> graph = TinkerFactory.createModern()
==>tinkergraph[vertices:6 edges:6]
gremlin> g = graph.traversal()
==>graphtraversalsource[tinkergraph[vertices:6 edges:6], standard]
gremlin>  l = g.V(1).local( outE('knows') ).group().by( __.outV().id() ).by( __.inV().id().fold() ).fold().next()
==>[1:[2, 4]]
gremlin> l[0].getClass()
==>class org.apache.tinkerpop.gremlin.process.traversal.step.map.GroupStep$GroupMap
gremlin> l[0].values().iterator().next().getClass()
==>class org.apache.tinkerpop.gremlin.process.traversal.step.util.BulkSet
gremlin> bs = l[0].values().iterator().next()
==>2
==>4
gremlin> bs[0].getClass()
==>class java.lang.Integer
gremlin> bs[1].getClass()
==>class java.lang.Integer
gremlin> bs.toString()
==>{2=1, 4=1}