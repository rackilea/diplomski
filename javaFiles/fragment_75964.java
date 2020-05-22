import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import java.util.Collection;
import java.util.Collections;
import jenkins.model.TransientActionFactory;


@Extension
public class MyTransientActionFactory extends TransientActionFactory<AbstractBuild> {
    @Override
    public Class<AbstractBuild> type() {
        return AbstractBuild.class;
    }

    @Override
    public Collection<? extends Action> createFor(AbstractBuild target) {
        return Collections.singleton(new MyAction(target));
    }
}