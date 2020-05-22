Ext.define('test.store.EmpIdStore', {
extend: 'Ext.data.Store',
alias : 'widget.empIdStore',
autoLoad: false,
fields: ['id', 'userId'],
proxy: {
    type: 'ajax',
    url: 'test/empIdList',
    reader: {
        type: 'json',
        root: 'data'
    }
}
});