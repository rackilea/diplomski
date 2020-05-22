<Context
    path="/tcadmin"
    docBase="${catalina.home}/server/webapps/admin"
    privileged="true"
>
    <Valve className="org.apache.catalina.valves.RemoteAddrValve"
        allow="127\.0\.0\.1"
    />
</Context>