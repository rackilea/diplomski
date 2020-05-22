for (String agentName : _ini.keys("start")){
    String agent = _ini.get("start" , agentName);
    Agent agent1 = _agents.get(agent);
    if (agent == null){
        System.out.print("ERROR");
        return null;
    } else {
        return agent1;
    }
    return null;
}