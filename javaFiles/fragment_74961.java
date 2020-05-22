<copy file="${basedir}/.project.base" tofile="${basedir}/.project">
<filterchain>
    <replacetokens>
        <token key="BRANCH" value="${branch}"/>
    </replacetokens>
</filterchain>
</copy>