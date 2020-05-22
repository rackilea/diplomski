catch( Exception ex ){
        int count = repeatedExDetector.countException( ex );
        if( count < 2 )
            log.error("Error rendering: " + path, ex);
        else
            log.error("Recurring rendering error: " + path);
        add( new TexyDocumentErrorPanel("document", "Error occured when loading document.", "Couldn't load: " + path, 500));
    }