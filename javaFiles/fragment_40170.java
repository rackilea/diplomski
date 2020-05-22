$('#validaButton').click(function() {

    alert("validazione");
    alert("CHECKED ROWS: " + checkedRowList.length);
    alert(checkedRowList[0]);

    $.ajax({
        type: "POST",
        data: JSON.stringify(checkedRowList),
        url: "validaProgetti",
        contentType:"application/json"
    }).done(function(response) {
        alert("SUCCESS");

    }).error(function(xhr) {
        alert("ERROR");
        manageError(xhr);
    });

});