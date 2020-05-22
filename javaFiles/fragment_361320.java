FileItems fileItems = null;
    int i = 0;
    for (File tmp : mResultList) {

        mFileArray[i] = tmp.getTitle();
        mDownloadUrl[i] = tmp.getId();
        i++;

        fileItems=new FileItems();//create new object for every new item

        fileItems.setTitle(tmp.getTitle());
        fileItems.setFileId(tmp.getId());
        mListFileItems.add(fileItems);
    }