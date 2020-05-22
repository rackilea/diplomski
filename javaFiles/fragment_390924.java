$('.getAjaxForThisContainer').click(function(e) {
    var idToGet = $("#someField").val();
    $.ajax({
        type : 'GET',
        url : '@routes.Application.getItem()',
        data : {
            id: idToGet
        },
        success : function(data) {
            // ... some code on success
        }
    });
    return false;
});