$(document).ready(function(){
    var theDivContents = $('#div-id').text();
    var newLinkHref= $('#link-id').attr('href') + "&divContents=" + theDivContents;

    $('#link-id').attr('href', newLinkHref);
});