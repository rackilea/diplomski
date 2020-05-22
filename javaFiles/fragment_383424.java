$(function() {
$( "#slider-range-min-amber" ).slider({
        range: "min",
        value: 0,
        min: 0,
        max: 100,
        slide: function( event, ui ) {
            $( "#amberData" ).val( "0 - " + ui.value );
        }
    });
    $( "#amberData" ).val( "$" + $( "#slider-range-min-amber" ).slider( "value" ) );
}); 

$(function() {
$( "#slider-range-min" ).slider({
    range: "min",
    value: 0,
    min: 0,
    max: 100,
    slide: function( event, ui ) {
        $( "#greenData" ).val( "0 - " + ui.value );
        var value = ui.value;
        var max = ui.value;
        $( "#slider-range-min-amber" ).slider("option","max",max).slider("value",value);
        $( "#amberData" ).val( "0 - " + ui.value );

    }
});
$( "#greenData" ).val( "$" + $( "#slider-range-min" ).slider( "value" ) );
});