public void wikiDumpReader(String dumpfile) {
            WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser(dumpfile);
            System.out.println("Going to process dump file");
            try {

                wxsp.setPageCallback(new PageCallbackHandler() {
                    @Override
                    public void process(WikiPage page) {

                        System.out.println(page.getTitle());
                    }

                });

                wxsp.parse();
            } catch (Exception e) {
                System.err.println("Error :" + e);
            }
        }