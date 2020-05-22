import static org.jboss.as.controller.client.helpers.ClientConstants.CHILD_TYPE;
import static org.jboss.as.controller.client.helpers.ClientConstants.DEPLOYMENT;
import org.jboss.as.controller.client.helpers.Operations;

ModelNode op = Operations.createOperation("read-children-names");
op.get(CHILD_TYPE).set(DEPLOYMENT);
final ModelNode listDeploymentsResult = client.execute(op);