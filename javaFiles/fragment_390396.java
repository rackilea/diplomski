$(".Yes, .No").click(function(){
    $.ajax({
    url: 'addLike',
    data: {
           id : $(this).next('.personId').val();
           }
    });
});