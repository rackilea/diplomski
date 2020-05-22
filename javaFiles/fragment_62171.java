if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
   newSeller.sort(Comparator.comparing(SellerObject::getDistance));
}else{
    Collections.sort(newSeller, new Comparator<SellerObject>() {
        @Override
        public int compare(SellerObject item1, SellerObject item2) {
            return item1.getDistance.compareTo(item2.getDistance);
        }
    });
}