import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
...
StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
ksession.addEventListener(new DebugWorkingMemoryEventListener() {
    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        System.out.println(event);
    }

    @Override
    public void objectRetracted(ObjectRetractedEvent event) {
        System.out.println(event);
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        System.out.println(event);
    }
});