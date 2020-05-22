function showHelp(title, url)
{
  var $dialog = $('<div></div>')
    .load(url)
    .dialog({
        show: "fade",
        hide: "fade",
        modal: true,
        title: title,
        width: 500,
        height: 300
      });    
    }