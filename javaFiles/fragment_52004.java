setInterval(function(){
  $.post('/servlet', count:getCount(), function(data){ 
     //If data has feeds (it's not 0)
     if(data != 0) {
       var lastFeed = data[data.length - 1];
       $('#feedContainer').append('<div>' + lastFeed.title + '<br/>' +   lastFeed.description + '</div>';
     }
  });
}, 5000);