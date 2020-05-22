add_myAgents();
for(String p : agent.getParameterNames())
{
    myAgents.get(myAgents.size()-1).setParameter(p, agent.getParameter(p), true);
}
enter.take(myAgents.get(myAgents.size()-1));