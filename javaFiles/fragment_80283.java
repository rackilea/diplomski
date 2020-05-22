// action when item file is clicked
$("li span.file").click(function(){

    // get the ID
    console.log($(this).attr('id'));

    $.getJSON('BomItemToJSON', function(data) {
        alert('entered getJSON()');
        var id = data.itemId;
        var description = data.description;

        alert('description: ' + description);

        formObject = document.forms['itemForm'];
        formObject.elements['itemId'].value = id;
        formObject.elements['itemDescription'].value = description;

        alert('done with javascript');
    });

});