if (requestedUri.toLowerCase().contains("new")){
registerNewAsset();
}else if (requestedUri.toLowerCase().contains("edit")){
editAsset(asset_id);
}else if (requestedUri.toLowerCase().contains("delete")){
deleteAsset(asset_id);
}else if (requestedUri.toLowerCase().contains("list")){
listAssets()
}