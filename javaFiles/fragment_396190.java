return Observable.combineLatest(
    targetIdList,
    KalturaVideoRetriver.getVideoList(BuildPlaylistStep2Activity.this, kalturaPlaylistId),
    (String[] idListOfTarget, KalturaVideo kalturaVideo) -> {
        ...
        return kalturaVideo;
    })