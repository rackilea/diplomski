<#assign minititle=(row.title!"")>
<#if minititle?length &lt; 27>
${minititle}
<#else>
${minititle?substring(0,26)} ...
</#if>