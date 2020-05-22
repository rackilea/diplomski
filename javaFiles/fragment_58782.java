Ext.define("MyApp.model.Form", {
    extend: "Ext.data.Model",
    fields: [
        {name: "member1", type: "string"},
        {name: "member2", type: "string"},
    ],
    hasMany: {
        model: "MyApp.model.AnotherType",
        name: "membersList",
        associationKey: "membersList"
    }
});

Ext.define("MyApp.model.AnotherType", {
    extend: "Ext.data.Model",
    fields: [
        {name: "value", type: "string"},
        {name: "label", type: "string"},
    ]
});