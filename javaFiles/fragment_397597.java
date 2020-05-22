...
<jdbc:initialize-database data-source="dataSource"
    ignore-failures="DROPS" enabled="${jdbc.enableSqlScripts}">
    <jdbc:script location="${jdbc.initLocation}" />
    <jdbc:script location="${jdbc.dataLocation}" />
</jdbc:initialize-database>
...