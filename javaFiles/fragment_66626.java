for(Shop shop : this.response.shops){
    //remember to check is shop.getShopLat() is not null etc..
    for(int i = 0; i < shop.getShopLat().size(); i++){
        map.addMarker(new MarkerOptions().position(new LatLng( shop.getShopLat().get(i), shop.getShopLng().get(i) )).title( shop.getShopAddress().get(i) ));
    }
}