$(document).ready(function(){

    $("#identity").click(function(e){
        e.preventDefault();
        if ($(this).hasClass("active") ) {
            $("#fromfrancetoggle").animate({opacity: "1"}, 500 );
            $("#lamiettetoggle").animate({opacity: "1"}, 500 );         
            $(this).removeClass("active");
        } else {
            $("#fromfrancetoggle").animate({opacity: "0"}, 500 );
            $("#lamiettetoggle").animate({opacity: "0"}, 500 );  
            $(this).addClass("active"); 
        }
        return false;
    });
    $("#identity").trigger("click"); // initial fade
});