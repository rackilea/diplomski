@table:table-row
[#if row.bar = "ipsum"]
    [#assign rowcolor='MyStyleTable.A1']
[#else]
    [#assign rowcolor='MyStyleTable.B1']
[/#if]
@/table:table-row

@#table:table-cell 
table:style-name=${rowcolor}