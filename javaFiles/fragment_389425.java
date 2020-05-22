document
  .getElementById('str')
  .addEventListener('input', function() {
    var bytes = encodeURI(this.value).split(/%..|./).length - 1;
    // your logic...

    console.clear();
    console.log(bytes + ' bytes');        
  });