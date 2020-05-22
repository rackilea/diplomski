<#if foo ??>
    <#if foo.barMap ??>
        <#list foo.barMap?keys as barKey>
            <tr>
                <td>
                    <!-- this input field is for display purposes only -->
                    <input name="tagKey" type="text" value="${tagKey}"/>
                </td>
                <td>
                    <!-- this input field populates the map -->
                    <input name="tagMap[${tagKey}]" type="text" value="${foo.tagMap[tagKey]}"/>
                </td>
            </tr>
        </#list>
    </#if>
</#if>