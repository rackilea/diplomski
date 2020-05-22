session = resourceResolver.adaptTo(Session.class);  
String assetPath = "/content/dam/folderA/asset1.jpg";
String movePath = "/content/dam/folderB/asset1.jpg";
assetManager.moveAsset(assetPath, copyPath);

session.save()
session.logout()