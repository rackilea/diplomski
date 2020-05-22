<s:if test="%{licenseStatusString != null}">
 ... something that uses licenseStatusString
</s:if>
<s:else>
 ... optional thing to include if the license status string is null.
</s:else>