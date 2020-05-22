$("#Category").autocomplete({
  delay: 100,
  autoFocus: true,
  selectFirst: true,
  source: 'ProviderSuggest.jsp',
  select: function (event, ui) {
    $('#autosuggest').val('Y');
  }
}).data('autocomplete')._renderItem = function(ul, item) {
   return $("<li>").data("item.autocomplete", item).append("<a data-id='"+item.CategoryID+"'>" + item.Category + "</a>").appendTo(ul);
};