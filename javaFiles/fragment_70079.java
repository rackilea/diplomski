gremlin> bindings = new javax.script.SimpleBindings()
gremlin> bindings.put('g', TinkerFactory.createModern().traversal())
gremlin> engine = new org.apache.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine()
==>org.apache.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine@7b676112
gremlin> results = engine.eval("g.V(1)", bindings).toList()
==>v[1]
gremlin> mapper = GraphSONMapper.build().version(GraphSONVersion.V3_0).create().createMapper()
==>org.apache.tinkerpop.shaded.jackson.databind.ObjectMapper@7f5b9db
gremlin> mapper.writeValueAsString(results)
==>{"@type":"g:List","@value":[{"@type":"g:Vertex","@value":{"id":{"@type":"g:Int32","@value":1},"label":"person","properties":{"name":[{"@type":"g:VertexProperty","@value":{"id":{"@type":"g:Int64","@value":0},"value":"marko","label":"name"}}],"age":[{"@type":"g:VertexProperty","@value":{"id":{"@type":"g:Int64","@value":1},"value":{"@type":"g:Int32","@value":29},"label":"age"}}]}}}]}