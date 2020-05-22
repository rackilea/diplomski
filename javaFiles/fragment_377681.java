[
    {
        statusCode: 200,
        method: 'GET',
        url: 'http://foo.com/index.html',
        bytes: 12422,
        start: '2009-03-15T14:23:00.000-0700',
        end: '2009-03-15T14:23:00.102-0700',
        timeInMillis: 102,
        requestHeaders: [
            {
              name: 'Foo',
              value: 'Bar'
            },
            {
              name: 'Name2',
              value: 'Value2'
            },
            ...
        ],
        responseHeaders: [
            {
              name: 'Baz',
              value: 'Blah'
            },
            {
              name: 'Name3',
              value: 'Value3'
            },
            ...
        ]
    },
    {
        ...
    },
    ...
]