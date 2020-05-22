<property name="lines"
    value="line01${line.separator}line02${line.separator}line03"/>

<target name="count-lines">
  <resourcecount property="line.count" count="0" when="eq">
    <tokens>
      <concat>
        <filterchain>
          <tokenfilter>
            <stringtokenizer delims="${line.separator}" />
          </tokenfilter>
        </filterchain>
        <propertyresource name="lines" />
      </concat>
    </tokens>
  </resourcecount>
  <echo message="${line.count}" />
</target>