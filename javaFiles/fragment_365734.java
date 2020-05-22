function allocationg_you(){
    var val1 = jQuery("#value1").val();
    var val2 = jQuery("#value2").val();
    var val3 = jQuery("#value3").val();
    jQuery.ajax({
        url: "allocator",
        data: "val1=" + val1 +"&val2=" + val2 + "&val3=" + val3 + "&r=" //dont forget to add a random number
        success: function(data){
                        jQuery("#mytable").html(data).load();
                 }
});
}