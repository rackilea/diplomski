.state('book', {
        parent: 'entity',
        url: '/book',
        data: {
            // authorities: ['ROLE_USER'],
            pageTitle: 'monoApp.book.home.title'
        },
        ....
    })
    .state('book-detail', {
        parent: 'entity',
        url: '/book/{id}',
        data: {
            // authorities: ['ROLE_USER'],
            pageTitle: 'monoApp.book.detail.title'
        },