String tagName = "nofilter";
TagInfoFeed feed = instagram.getTagInfo(tagName);

TagInfoData tagData = feed.getTagInfo();
System.out.println("name : " + tagData.getTagName());
System.out.println("media_count : " + tagData.getMediaCount());