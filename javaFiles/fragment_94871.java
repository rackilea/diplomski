<urlrewrite>
    <rule>
       <from>^/demo/api.do?method=getUser&amp;uid=(.*)$</from>
       <to>/demo/api/user/$1</to>
    </rule>
</urlrewrite>