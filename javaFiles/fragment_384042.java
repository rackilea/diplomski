$('.link').click(function(e) {
    e.preventDefault(); // if you have a URL in the link
    var addressValue = $(this).attr("href");
    $("#youriframe").attr('src',addressValue);
    });
});