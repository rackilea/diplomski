//use id of div(that contains the widgets) that 
//you want to hide before all widget are shown
$('#my_div_id')
    .hide()  // hide it initially and then use load event handler
    .load(function() {
        $(this).show();//display/show the div when load completes
    })
;