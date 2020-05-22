<interfaces>
   <interface name="management">
       <inet-address value="${jboss.bind.address.management:127.0.0.1}"/>
   </interface>
   <interface name="public">
        <inet-address value="${jboss.bind.address:127.0.0.1}"/>
   </interface>
    ....
</interfaces>