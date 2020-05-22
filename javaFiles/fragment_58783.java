Ext.create("Ext.form.ComboBox", {
    fieldLabel: "Members",
    store: Ext.getStore("MyApp.store.Mystore").getAt(0).membersList(),
    queryMode: "local",
    displayField: "label",
    valueField: "value",
    renderTo: Ext.getBody()
});