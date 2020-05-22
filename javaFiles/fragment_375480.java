Element thead = view.datagrid.getElement().getElementsByTagName("thead").getItem(0);
    Element tr;
        tr = thead.getElementsByTagName("tr").getItem(0);
    for (int i = 0; i < tr.getChildCount(); i++) {
        Element th = tr.getElementsByTagName("TH").getItem(i);
        String headerText = th.getInnerHTML();
        String sortHeader = "";
        String colspanValue = th.getAttribute("colspan");
        if (th.getChildCount() == 1) {
            Element div = th.getElementsByTagName("DIV").getItem(0);
            sortHeader = null != div ? div.getElementsByTagName("DIV").getItem(1).getInnerHTML()
                    : "";
        }
        if (sortHeader.equalsIgnoreCase("COLUMHEADER1") && colspanValue.equals("1")) {
            th.setAttribute("colspan", "2");
            Element thNext = tr.getElementsByTagName("TH").getItem(i + 1);
            thNext.setAttribute("style", "display: none !important");
        }