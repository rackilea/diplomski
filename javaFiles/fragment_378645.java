.state('resultAnalysisDetail', {
        parent: 'entity',
        url: '/resultAnalysisDetail?page&sort&search',
        params: {
            page: {
                value: '1',
                squash: true
            },
            sort: {
                value: 'id,asc',
                squash: true
            },
            search: null
        },
        resolve: {
            pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                return {
                    page: PaginationUtil.parsePage($stateParams.page),
                    sort: $stateParams.sort,
                    predicate: PaginationUtil.parsePredicate($stateParams.sort),
                    ascending: PaginationUtil.parseAscending($stateParams.sort),
                    search: $stateParams.search
                };
            }]
        }
    })