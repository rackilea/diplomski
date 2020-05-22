[
<#list root['abc'] as map>
  {
  <#list map?keys as key>
    ${key}: ${map[key]}
  </#list>
  }
</#list>
]