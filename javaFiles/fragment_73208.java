$(window).load(function () {
    var url = $('#analyticLog').attr('href');
    loc = /* the URL of the controller you wish to post to */;
    $.ajax({
        type: "POST",
        url: loc,
        success: function(html)
        {
                $("#analyticLogAjax").replaceWith($("#analyticLogAjax",$(html)));
        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
          }
    });
});