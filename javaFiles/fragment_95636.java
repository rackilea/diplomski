proxy: {
        id: 'proxyID',
        type: 'ajax',
        url: '../api/sampleRestJsonAPI',
        reader: {
            type: 'json',
            root: 'data'
        }