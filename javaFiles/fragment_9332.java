<path id="commons-lang.path">
     <fileset dir="${lib.dir}">
         <incude name="commons-lang*.jar"/>
     </fileset>
</path>

<fail message="Missing commons-lang Jar">
    <condition>
        <resourcecount refid="commons-lang.path" 
             when="equals" count="0"/>
    </condition>