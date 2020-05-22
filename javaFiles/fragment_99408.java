$scope.abms = [];
 console.log(news[0].NewsList);

angular.forEach(news[0].NewsList, function(newsItems, index) {
  angular.forEach(newsItems.CategoryList, function(category, index){
    $scope.abms.push(category.DisplayName);
  });
});