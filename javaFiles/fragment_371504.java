import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchDescription implements Comparable<MatchDescription> {

    private MatchType matchType;
    private int matchOrder = 0;
    private int subMatchOrder = 0;

    public MatchDescription(String name) {
        String matchName = name.toLowerCase().trim();
        String[] tokens = matchName.split("\\s+");

        matchType = MatchType.getByName(tokens[0]);

        if (matchType.hasMatchOrder()) {
            matchOrder = Integer.parseInt(tokens[1]);
        }
        if (matchType.hasSubmatches()) {
            subMatchOrder = Integer.parseInt(tokens[3]);
        }
    }