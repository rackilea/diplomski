for (String str : image.getRepoTags()) {
    if(str.contains(imageTag)) {
        return true;
    }
}
return false;