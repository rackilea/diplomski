public void invokeGoogleMap() { 
     int mh = CodeModuleManager.getModuleHandle("GoogleMaps");
     if (mh == 0) 
     {
          try 
          {
            throw new ApplicationManagerException("GoogleMaps isn't installed");
          } 
          catch (ApplicationManagerException e) 
          {
            System.out.println(e.getMessage());
          }
          UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
              stubDialog.inform("GoogleMaps isn't installed on your device.download it from m.google.com/maps.");
            }
          });
     }
     else
     {
         URLEncodedPostData uepd = new URLEncodedPostData(null, false);
         uepd.append("action", "ROUT"); // or LOCN
         uepd.append("start", "23.039568,72.566005");
         uepd.append("end", "23.02,73.07");
         String[] args = { "http://gmm/x?" + uepd.toString() };
         ApplicationDescriptor ad = CodeModuleManager.getApplicationDescriptors(mh)[0];
         ApplicationDescriptor ad2 = new ApplicationDescriptor(ad, args);
         try
         {
             ApplicationManager.getApplicationManager().runApplication(ad2, true);
         } 
         catch (ApplicationManagerException e) 
         {
             System.out.println(e.getMessage());
         }

     }
  }