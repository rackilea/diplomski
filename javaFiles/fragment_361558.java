Ext.Ajax.request({
            url: 'rest/submitValue?name=' + Ext.getCmp('name').getValue() + '&email=' + Ext.getCmp('email').getValue() + '&date=' + Ext.getCmp('date').getValue(), 
            method: 'GET',
            success: function (response) {

            },
            failure:function(response){

            }
        });



Ext.Ajax.request({
            url: 'rest/submitValue?name=' + Ext.getCmp('name').getValue() + '&email=' + Ext.getCmp('email').getValue() + '&date=' + Ext.getCmp('date').getValue(), 
            method: 'GET',
            params: {
                name: Ext.getCmp('name').getValue(),
                email : Ext.getCmp('email').getValue(),
                date : Ext.getCmp('date').getValue()
            }
            success: function (response) {

            },
            failure:function(response){

            }
        });