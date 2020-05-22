<script>
function GetSearchResults(){
    // make your ajax call here
    $.ajax({
      async: false,
      url: 'customsearch.php?q=Lemons',
      success: function(data) {
        var availableTags = [];
        // build an array from the response data here
        $( "#tags" ).autocomplete({
            source: availableTags
        });
      }
    });
}

$(function() {
    var availableTags = GetSearchResults();
});
</script>

<div class="demo">

<div class="ui-widget">
<label for="tags">Tags: </label>
<input id="tags" />
</div>

</div><!-- End demo -->

<div class="demo-description">
<p>The Autocomplete widgets provides suggestions while you type into the field. Here the suggestions     are tags for programming languages, give "ja" (for Java or JavaScript) a try.</p>
<p>The datasource is a simple JavaScript array, provided to the widget using the source-    option.</p>
</div><!-- End demo-description -->