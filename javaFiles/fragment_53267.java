// For each file: check if files are images
for (i = 0; i < files.length; i++) {
    if (!files[i].type.match('image.*')) { // Replace with what you need
        $('#dropAppearance p').html('Hey! Images only');
        return false;
    }
}