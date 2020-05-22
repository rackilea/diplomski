picker = PickerBuilder.create().addCallback( new AbstractPickerCallback(){



@Override
public void onCanceled() {
    // TODO Auto-generated method stub

}

@Override
public void onPicked(ViewToken viewToken, BaseResult result) {
    $.console.log(result);
    DocumentResult docs = result.<DocumentResult>cast();
    String mediaUrl = docs.getDocs().get(0).getEmbedUrl();
    String thumbnail = docs.getDocs().get(0).getThumbnails().get(0).getUrl();
    handler.setMediaUrl(thumbnail);
    handler.setMediaUrl(mediaUrl);
    $.console.log("The handler is " + handler);
    pickerCell.setValue(null, null, handler);


}})
.setAppId(appId)
                .setAuthUser(appUser.getAcctId()).setOAuthToken(appUser.getAuthToken())
                .addView(ViewId.DOCS).addView(ViewId.YOUTUBE)
                .hideTitleBar().build();
        picker.setVisible(false);