final native void create(String id) /*-{
        var _self = this;
        $wnd.jQuery("#" + id).dialog({ 
            autoHide: true, 
            close: function(event, ui) {
                _self.@your.package.Dialog::onClose()();
                _self = null;
            }
        });
    }-*/;