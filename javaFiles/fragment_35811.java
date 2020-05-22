List<PostDetail> onlinePostDetail = new ArrayList();
 List<PostDetail> offlinePostDetail = new ArrayList();
 for(PostDetail p: posts) {
     if(p.getDeviceStatus().equals("Online")) {
         onlinePostDetail.add(p);
     } else if(p.getDeviceStatus().equals("Offline")) {
         offlinePostDetail.add(p);
     }
 }