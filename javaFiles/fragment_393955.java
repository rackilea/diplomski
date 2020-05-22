import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.Operation;
import org.jboss.as.controller.client.helpers.Operations.CompositeOperationBuilder;
import org.jboss.dmr.ModelNode;

public class ExampleOperation {

    public ModelNode executeCompositeOperation(final ModelControllerClient client, final ModelNode... ops) throws IOException {
        final CompositeOperationBuilder builder = CompositeOperationBuilder.create(true);
        for (ModelNode op : ops) {
            builder.addStep(op);
        }
        final ModelNode result = client.execute(builder.build());
        if (!Operations.isSuccessfulOutcome(result)) {
            throw new RuntimeException(Operations.getFailureDescription(result).asString());
        }
        return Operations.readResult(result);
    }
}