$http.get(url)
.then(function (response) {
    console.log('get',response)
})
.catch(function (data) {
    // Handle error here
});