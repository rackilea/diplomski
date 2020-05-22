public class Dialog extends Composite {

    public Dialog(IsWidget body) {
        initWidget(body.asWidget());
    }

    public void create() {
        create(getElement());
    }

    public void open() {
        onAttach();
        RootPanel.detachOnWindowClose(this);
        open(getElement());
    }

    void onClose() {
        if(RootPanel.isInDetachList(this)) {
            RootPanel.detachNow(this);
        }
        else {
            onDetach();
        }
    }

    final native void create(Element element) /*-{
        var _self = this;
        $wnd.jQuery(element).dialog({ 
            autoHide: true, 
            close: function(event, ui) {
                _self.@your.package.Dialog::onClose()();
                _self = null;
            }
        });
    }-*/;

    final native void open(Element element) /*-{
        $wnd.jQuery(element).dialog("open");
    }-*/;
}