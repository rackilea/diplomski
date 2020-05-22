final RepeatingView rv = new RepeatingView("rv");
rv.add(new MyPanel(rv.newChildId()));
...
AjaxLink addPanelLink = new AjaxLink("addPanelLink") {
     public void onSubmit(AjaxRequestTarget target) {
         MyOtherPanel pnl = new MyOtherPanel(rv.newChildId())
         rv.add(pnl);
         target.prependJavaScript(String.format(
                "var item=document.createElement('%s');item.id='%s';var container = $('%s'); container.append(item,container.firstChild);",
                "div",
                pnl.getMarkupId(),
                ".dom_parent_div_id"));
         target.add(pnl);
     }
};