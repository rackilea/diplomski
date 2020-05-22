$http.post('http://localhost:1011/productDetails', { Id: 12 }, {
              headers: {
                  'Content-MD5': '917200022538',
                  'Accept': 'application/Json',
                  'Content-Type': 'application/Json'
              }
          }).then(onUserComplete, onError);

    var onUserComplete = function (response) {
        $scope.Products = response.data;
    };

    var onError = function (reason) {
        $scope.error = "Error while fetching records.";
    };