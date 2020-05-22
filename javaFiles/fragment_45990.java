import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum Datacenter {

   ABC(Env.PROD, "tcp://machineA:8081", "tcp://machineA:8082"), 
   DEF(Env.PROD, "tcp://machineB:8081", "tcp://machineB:8082"), 
   PQR(Env.PROD, "tcp://machineA:8081", "tcp://machineA:8082"), 
   CORP(Env.STAGING, "tcp://machineC:8081", "tcp://machineC:8082");

    public static enum Env {
        PROD, STAGING
    }

    private Env env;
    private String[] url;

    private static final ImmutableMap<Datacenter, ImmutableList<String>> PROD_SERVERS_BY_DC;
    private static final ImmutableMap<Datacenter, ImmutableList<String>> STAGING_SERVERS_BY_DC;
    private static final Map<Env, ImmutableMap<Datacenter, ImmutableList<String>>> SERVERS_BY_ENV;

    static {

        Builder<Datacenter, ImmutableList<String>> prodDataCenterBuilder = ImmutableMap.<Datacenter, ImmutableList<String>>builder();
        Builder<Datacenter, ImmutableList<String>> stagingDataCenterBuilder = ImmutableMap.<Datacenter, ImmutableList<String>>builder();

        for (Datacenter datacenter : Datacenter.values()) {
            if (datacenter.env == Env.PROD) {
                prodDataCenterBuilder.put(datacenter, ImmutableList.of(datacenter.url));
            } else if (datacenter.env == Env.STAGING) {
                stagingDataCenterBuilder.put(datacenter, ImmutableList.of(datacenter.url));
            }

            else {
                throw new IllegalArgumentException("not exepected env " + datacenter.env);
            }
        }

        PROD_SERVERS_BY_DC = prodDataCenterBuilder.build();
        STAGING_SERVERS_BY_DC = stagingDataCenterBuilder.build();

        SERVERS_BY_ENV = new HashMap<>();
        SERVERS_BY_ENV.put(Env.PROD, PROD_SERVERS_BY_DC);
        SERVERS_BY_ENV.put(Env.STAGING, STAGING_SERVERS_BY_DC);

    }

    Datacenter(Env env, String... url) {
        this.env = env;
        this.url = url;
    }    

    public static ImmutableMap<Datacenter, ImmutableList<String>> getServers(Env env) {
        ImmutableMap<Datacenter, ImmutableList<String>> map = SERVERS_BY_ENV.get(env);
        if (map == null) {
            throw new IllegalArgumentException("not exepected env " + env);
        }
        return map;
    }

}