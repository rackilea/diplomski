beforeProcessing: function (response) {
    var $self = $(this), orderStatus = response.orderStatus, i, values = "";
    if (orderStatus != null && orderStatus.length > 0) {
        for (i = 0; i < orderStatus.length; i++) {
            if (values.length > 0) {
                values += ";";
            }
            values += orderStatus[i].id + ":" + orderStatus[i].name;
        }
        $self.jqGrid("setColProp", "orderStatus", {
            editoptions {
                value: values
            }
        });
        if (this.ftoolbar) { // filter toolbar exist
            $self.jqGrid("destroyFilterToolbar");
            $self.jqGrid("filterToolbar");
        }
    }
}