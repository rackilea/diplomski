<gfe:local-region id="LocalRegion1">
    <gfe:region-ttl timeout="${local.region1.ttl}" action="DESTROY"/>
    <gfe:cache-listener>
        <bean
            class="com.mycompany.util.LoggingCacheListener" />
    </gfe:cache-listener>
</gfe:local-region>