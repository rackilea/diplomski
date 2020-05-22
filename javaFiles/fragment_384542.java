...
 userColumn = new Column<User, SafeHtml>(new SafeHtmlCell()) {
      @Override
      public SafeHtml getValue(User user) {
        SafeHtmlBuilder sb = new SafeHtmlBuilder();
        sb.appendHtmlConstant("<table style=\"width:100%\">");
        for (Product product : user.getProducts()) {
            sb.appendHtmlConstant("<tr>");
            sb.appendHtmlConstant("<td>" +product.getProductNumber()+"</td>");
            sb.appendHtmlConstant("<td>" +product.getName()+"</td>");
            sb.appendHtmlConstant("<td>" +product.getQuality()+"</td>");
            sb.appendHtmlConstant("<tr>");
        }
        sb.appendHtmlConstant("</table>");
        return sb.toSafeHtml();
      }
    };