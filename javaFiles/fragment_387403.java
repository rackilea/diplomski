gremlin> g = new TinkerGraph()
==>tinkergraph[vertices:0 edges:0]
gremlin> g.addVertex(["num":123])
==>v[0]
gremlin> g.addVertex(["num":2306416072])
==>v[1]
gremlin> g.v(0).num.getClass()
==>class java.lang.Integer
gremlin> g.v(1).num.getClass()
==>class java.lang.Long
gremlin> g.saveGraphML("/tmp/numtest.xml")
==>null

gremlin> h = new TinkerGraph()
==>tinkergraph[vertices:0 edges:0]
gremlin> h.loadGraphML("/tmp/numtest.xml")
==>null
gremlin> h.V().map()
==>{num=2306416072}
==>{num=123}
gremlin> h.v(0).num.getClass()
==>class java.lang.Long
gremlin> h.v(1).num.getClass()
==>class java.lang.Long