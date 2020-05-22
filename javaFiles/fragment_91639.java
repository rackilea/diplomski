public class t implements it {
    // Do initialisation and class injection. Y is constructor injected
    private final B b;

    public t(B b) {
       this.b = b;
    }

    @Override
    @Transactional
    public void handleEvent(EventContext context) {
        switch (context.getEventType()) {
            case event:
                validate(context);
                break;
        }
    }

    // You can skip this method and simply call b, but in my scenario we do a couple of other things that do not have to be part of the transaction
    private void validate(EventContext context) {
        try {
            b.allLogicMethod(context.getObjectUuid());
        } catch(Exception e) {
            // Here we break the event so we can retry it, but the transaction succeeded in case it was a checked Exception
            throw new RuntimeException(e);
        }
    }
}

public class b implements IB {

    private final Y y;

    Public B(Y y) {
        this.Y = y;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void allLogicMethod(String uuid) {
        try {
            Object o = crudService.findByProperty(context.getObjectUuid());
            if (!o.check) {
                y.changeStatus(o, ERROR);
                // break for retry
                throw new CheckedException("Some serious message log");
            } else {
                // do everything else
            }
        } catch(CheckedException ce) {
            throw ce;
        } catch(Exception e) {
            throw new RuntimeException("some message", e);
        }
    }
}

public class Y implements IY {

    @Override
    public void changeStatus(Object o, String status) {
        // We do a lot more here then just change this status because of inheriting objects but for the sake of the argument, change status
        o.status = status;
    }
}