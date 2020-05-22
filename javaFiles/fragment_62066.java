$.getJSON('/test', function(data) {
  // if data is an array of objects like [{...}, {...}] then
  data.forEach(function(item) { 
    for(key in item) { 
      console.log(key + ", " item[key]);
  });
});