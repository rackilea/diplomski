$('#requestForm').submit(function(e){
    e.preventDefault();

    $.ajax({
        url: '/admin/reservation/save',
        type: 'POST',
        dataType:'json',
        data: JSON.stringify(reservation),
        success: function(response){
            console.log(response)
        },
        failure: function (response){
            console.log(response)
        }
    })
})