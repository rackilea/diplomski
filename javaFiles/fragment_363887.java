$('.pagination').click(function(e){
    e.preventDefault(); //prevent default click behavior for a link
    limit = 10;                         //hard code the limit (rows/page)
    offset = $(this).data('offset');    //get the offset for the link clicked
    $.ajax({                            //ajax
        type : 'POST',
        url : '../auctionsDisplay',
        data : {
        "type"      : "1",
        "category"  : category,
        "limit"     : limit,        //set limit
        "offset"    : offset        //set offset
    }
    .done(function(){               //success is deprecated, use done
        $("#result2").html(data);
    })
    .fail(function(jqXHR){          //dump the info to the console (hit f12 to see that in a browser)
        console.log(jqXHR);
        alert("aw damn, something bad happened");
    })
    .always(function(){             //this always happens, doesn't matter if it hits done or fail
        alert("I always happen, done or fail, rain or shine.  You can remove me.");
    })
});
})