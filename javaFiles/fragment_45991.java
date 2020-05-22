public static void main(String[] args) {        
    ImmutableMap<Datacenter, ImmutableList<String>> servers = Datacenter.getServers(Env.PROD);
    servers.forEach((k, v) -> System.out.println("prod datacenter=" + k + ", urls=" + v));

    servers = Datacenter.getServers(Env.STAGING);
    servers.forEach((k, v) -> System.out.println("staging datacenter=" + k + ", urls=" + v));
}