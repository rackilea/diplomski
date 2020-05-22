function submitArticle() {
    var pdata = $('textarea').froalaEditor('html.get');
    $.post("controller/path", pdata).done(function(response) {
        comsole.log("Response: " + response);
    });
}