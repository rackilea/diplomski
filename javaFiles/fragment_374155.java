$(function(){
    $("select").multiselect();
    $('input').prop('title', '');


    $( document ).tooltip();
    $( document ).tooltip( "option", "position", { my: "left+20 center", at: "right center" } );
});