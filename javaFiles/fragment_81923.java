<profile name="default" xlink:href="${openorb.home}config/default.xml#default">
    <description>
        The default profile loads the POA, iiop and some basic initial references.
    </description>      

    <import xlink:href="${openorb.home}config/default.xml#iiop">
        <property name="port" value="684"/>
    </import>       
</profile>