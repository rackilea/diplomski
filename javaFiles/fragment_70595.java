final AJAXDownload download = new AJAXDownload()
 {
     private static final long serialVersionUID = 1L;

     @Override
     protected IResourceStream getResourceStream()
     {
         StringResourceStream bar = new StringResourceStream (new String(xmlFileInBytes) );
                 return (IResourceStream) bar;
         }
     };