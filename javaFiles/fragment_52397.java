public class Agents {

    private static Agents theInstance;

    private final Map<String, Agent> AGENTS_MAP;

    private Agents() {
        this.AGENTS_MAP = new HashMap<>();
    }

    public static Agents getInstance() {
        if (theInstance == null) {
            theInstance = new Agents();
        }

        return theInstance;
    }

    public Agent getAgent(String agentName) {
        if (!AGENTS_MAP.containsKey(agentName) {
            initAgent(agentName);
        }

        return AGENTS_MAP.get(agentName);
    }

    // TODO handle errors
    private static void initAgent(String agentName) {
        ObjectMapper mapper = new ObjectMapper();
        Agent agent = mapper.readValue(new File(agentName), Agent.class);
        AGENTS_MAP.put(agentName, agent);
    }
}