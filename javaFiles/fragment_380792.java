import org.apache.tinkerpop.gremlin.structure.Column;
import org.apache.tinkerpop.gremlin.process.traversal.Order;
import org.apache.tinkerpop.gremlin.process.traversal.Scope;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.*;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;

g.V().outE().
 group().
   by(inV().values("name")).
   by(values("weight").sum()).
 order(Scope.local).
   by(Column.values, Order.desc)