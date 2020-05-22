String config = "MediaEntryModuleImpl.player=null\n" +
                "MediaEntryModuleImpl.interface=interface\n" +    
                "com.sun.syndication.feed.module.mediarss.MediaModule\n" +
                "MediaEntryModuleImpl.uri=http://search.yahoo.com/mrss/\n" +
                "MediaEntryModuleImpl.metadata.hash=null\n" +
                "MediaEntryModuleImpl.metadata.descriptionType=null\n" +
                "MediaEntryModuleImpl.metadata.copyright=null\n" +
                "MediaEntryModuleImpl.metadata.copyrightUrl=null\n" +
                "MediaEntryModuleImpl.metadata.title=null\n" +
                "MediaEntryModuleImpl.metadata.thumbnail[0].time=null\n" +
                "MediaEntryModuleImpl.metadata.thumbnail[0].height=null\n" +
                "MediaEntryModuleImpl.metadata.thumbnail[0].width=320 \n" +
                "MediaEntryModuleImpl.metadata.thumbnail[0].url=http://whatever.com/wp-content/uploads/2013/11/mes1-300x186.png\n" +
                "MediaEntryModuleImpl.metadata.description=null\n" +
                "MediaEntryModuleImpl.metadata.titleType=null";

Properties properties = new Properties();
properties.load(new StringReader(config));

System.out.println(properties.get("MediaEntryModuleImpl.metadata.thumbnail[0].url"));