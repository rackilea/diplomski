class SimpleHandler implements OperationHandler {
 private OperationHandler next;

 public void handle(Operation op) {
     if (op.getType() == OperationType.SOMEYOURTYPE) {
        //do some stuff
     } else {
        next.handle(op);
     }
 }
}