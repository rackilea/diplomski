<dirset dir="${eclipse.workspace.dir}" id="workspacedirset">
    <!-- exclude your directory-->
    <exclude name="EXCLUDEME"/>
    <!-- include all others -->
    <include name="**"/>
</dirset>
<ant4eclipse:workspaceDefinition id="myworkspace">
    <dirset refid="worspacedirset"/>
</ant4eclipse:workspaceDefinition>