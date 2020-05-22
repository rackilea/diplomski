$("#SaveBtnId").click(function() {

ObjectC:{
bus:$('#txtBus').val(), //Considering as getting from textBox
dept:$('#txtBike').val(),
};

ObjectB:{
address:$('#txtAdd').val(), //Considering as getting from textBox
dept:$('#dept').val(),
obj:ObjectC
};

ObjectA:{
name: $('#txtName').val(),
college: $('#txtCollege').val(),
obj:ObjectB
};
        $.ajax({
            url : "../seller/addSeller",
            type : "post",
            data : JSON.stringify(objectA),
            contentType : "application/json",
            dataType : "json",
            success : function(data) {
                alert("Saved Successfully");
            },
            error : function(error) {
                alert(error);
                alert("Details failed to save");
            }
        });
    });