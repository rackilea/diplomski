<if>
 <not><equals arg1="${clients}" arg2="" /></not>
 <then>
   <foreach list="${clients}" delimiter=","
            target="clean other hosts" param="client.string"/>
 </then>
</if>