form = Ext.DomHelper.append(document.body, {
     action: '/exportExcel',
     cn: [{
        tag:'input',
        name : 'columnsToTitles',
        value : Ext.String.htmlEncode(Ext.JSON.encode(exportConfig[1]))
     },