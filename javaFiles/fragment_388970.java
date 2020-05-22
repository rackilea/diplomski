success: function (data) {
        $(data.products).each(function (index, item) {

            $("#"+item.id+" .name").html(item.name);
            $("#"+item.id+" .price").html(item.price);
            $("#"+item.id+" .store").html(item.store);

        });
    },
    error: function () {}

});.