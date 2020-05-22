for (DataSnapshot infoSnapshot : dataSnapshot.getChildren().getChildren()){

                 info info = infoSnapshot.getValue(info.class);
                 infoList.add(info);

}