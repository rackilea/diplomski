//Find divs inside the parent div that will contain your feeds
function getCount(){
  return $('#feedContainer').children().find('div').size().toString();
}

//Don't forget to pass it to your jQuery post like this 
//(Please, continue reading to understand where to put this)
$.post('/servlet', count:getCount(), function(data){ //manage your new feeds });