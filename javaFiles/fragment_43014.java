<hz:config>
    <hz:instance-name>${hz.instance.name}</hz:instance-name>
    <hz:group name="${hz.group.name}" password="${hz.group.password}"/>

    <hz:map name="default" 
        backup-count="2" max-size="0"
        time-to-live-seconds="25" eviction-percentage="30"
        eviction-policy="NONE"/>

    <hz:map name="userMap" 
        backup-count="2" max-size="0" 
        time-to-live-seconds="6000" eviction-percentage="30"
        eviction-policy="NONE"/>

    <hz:map name="FruitMap*" 
        backup-count="2" max-size="0" 
        time-to-live-seconds="10" eviction-percentage="30"
        eviction-policy="NONE"/>

</hz:config>

<hz:map instance-ref="ipds" id="userMapSpringId" name="userMap" />
<hz:map instance-ref="ipds" id="mangoMapSpringId" name="FruitMap1" />
<hz:map instance-ref="ipds" id="appleMapSpringId" name="FruitMap2" />
<hz:map instance-ref="ipds" id="alientFruitMapSpringId" name="AlienFruit" />