getImageList();
function getImageList() {
AnalyserRepository.getImageList().then(
function(result) {
alert("Result::"+result)
scope.imageList = result;
console.log("Image "+ scope.imageList);
});
};