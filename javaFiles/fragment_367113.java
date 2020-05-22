class EnvironmentMap {
    @XmlJavaTypeAdapter(value = EnvMapAdapter.class)
    @XmlElement(name = "Environments")
    public Map<String, String> envMap;
}

class Environments {
    @XmlElement(name = "Environment")
    public List<Environment> environments;
}

class Environment {
    @XmlAttribute(name = "Name")
    public String name;
    @XmlAttribute(name = "URIPath")
    public String uriPath;
}

class EnvMapAdapter extends XmlAdapter<Environments, Map<String, String>> {
    @Override
    public Map<String, String> unmarshal(Environments envs) throws Exception {
        Map<String, String> map = new HashMap<>();
        for (Environment env : envs.environments)
            map.put(env.name, env.uriPath);
        return map;
    }

    @Override
    public Environments marshal(Map<String, String> map) throws Exception {
        Environments environments = new Environments();
        // This method is only called if you marshal (Java -> XML)
        environments.environments = new ArrayList<>(map.size());

        for (Entry<String, String> entry : map.entrySet()) {
            Environment e = new Environment();
            e.name = entry.getKey();
            e.uriPath = entry.getValue();
            environments.environments.add(e);
        }

        return environments;
    }
}