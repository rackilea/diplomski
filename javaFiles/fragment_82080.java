<#list cars as c>
 ${c.id!'Unknown'} - ${c.name!'Unknown'}

 <#list c.engineList as t>
    ${t.id!'Unknown'} - ${t.name!'Unknown'}
 </#list>
 </#list>