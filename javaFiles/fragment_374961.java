import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


@Component
public class Foo {

    @Autowired
    @Qualifier("transitionProperties")
    private Properties transitionProperties;

    private Map<String, Set<String>> transitions = Maps.newHashMap();

    @PostConstruct
    public void loadTransitions() {

        for (Map.Entry<Object, Object> transitionList : transitionProperties.entrySet()) {

            String sourceState = (String) transitionList.getValue();

            if (!transitions.containsKey(sourceState)) {
                transitions.put(sourceState, Sets.<String>newHashSet());
            }

            Set<String> destinationStates = transitions.get(sourceState);

            for (String destinationState : Splitter.on(',').split((String) transitionList.getValue())) {
                destinationStates.add(destinationState);
            }
        }

    }

    public boolean isTransitionAllowed(String sourceState, String destinationState) {

        Set<String> destinationStates = transitions.get(sourceState);

        return destinationStates != null && destinationStates.contains(destinationState);
    }
}