$("#slideToggle").click(function () {   

$(this).html(($(this).html()=="Show full map"?"Hide map":"Show full map"));

// To move up
$(this).toggleClass("moveUp");

$('.slideTogglebox').slideToggle(500); 

});