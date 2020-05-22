'use strict';

angular.module('itmApp')
    .factory('CardGenerated', function ($resource) {
        return $resource('api/cardGenerated/:branchCode/:cardType', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            }
        });
    });