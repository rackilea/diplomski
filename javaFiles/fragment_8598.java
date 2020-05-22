int i=0;
String themeTune; //Your random themeTune will be stored here
for (DataSnapshot snap : snapshot.getChildren()) {
    if(i = randomNumber) {
        themeTune = snap.getValue(String.class);
        break;
    }
    i++;
}
plysound();