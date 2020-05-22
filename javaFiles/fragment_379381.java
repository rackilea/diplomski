String link = "http://www."+source.getLabel()+".com";
      try {
         AppletContext a = getAppletContext();
         URL url = new URL(link);
         a.showDocument(url,"_blank");
      }