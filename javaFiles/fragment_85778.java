function submitAndCloseChildWindow(){
    var data = /* get form data here */;
    $.ajax({
        url: "/rms/action/linkSourceList",
        data: data,
        method: "POST"
    }).done(function() {
        opener.location.href = '../action/editSource?source_id=' + $("#originalSource").val();
        window.close();
    });
}