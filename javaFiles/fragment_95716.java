,getUniqueValues:function(field) {
    var  me = this
        ,results = {}
    ;

    me.each(function(record){
        var value = record.get(field);
        results[value] = {};
        results[value][field] = value;
    });

    return Ext.Object.getValues(results);
} // eo function getUniqueValues