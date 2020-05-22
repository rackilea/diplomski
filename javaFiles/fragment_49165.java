// Create the Thumbnail task
String xmlThumbnail = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + 
       "<Thumbnail Size=\"" + size + "\" Type=\"Jpeg\" " + 
       "Filename=\"{OriginalFilename}_{Size}_{ThumbnailTime}_{ThumbnailIndex}_{Date}_{Time}.{DefaultExtension}\">" + 
       "<Time Value=\"" + time + "\"/></Thumbnail>";

Task.CreateBatchOperation task = Task
            .create(mediaProcessor.getId(), 
                    "<taskBody><inputAsset>JobInputAsset(0)</inputAsset><outputAsset>JobOutputAsset(0)</outputAsset></taskBody>")
            .setConfiguration(xmlThumbnail)
            .setName("MakeThumbnailTask");