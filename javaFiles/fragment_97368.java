<s:form
     id="deployChapters%{#chapterTree.nodeId}" 
     action="%{deployChapterUrl}"
     theme="simple"
     method="POST">
     <s:hidden name="nodeId" value"%{#chapterTree.nodeId}" />
</s:form>