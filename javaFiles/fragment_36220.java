$(".GN").click(function() {

        var yourVal = $(this).data('gnval');

        $.ajax({
            method: "POST",
            url: "test.action", // correct url ?
            data: {
                gnval: yourVal
            }
        });

 });