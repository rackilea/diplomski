for (int j = 0; j <5000; j += 1000) {
    table.setKeepTogether(true);
    document.newPage();
    for (int i = 2600; i > 0; i -= 1300) {
        clip = canvas.createTemplate(2000, 1300);
        clip.addTemplate(tableTemplate, -j, 1750 - i);
        canvas.addTemplate(clip, 50, 312);
        table.setKeepTogether(true);
        //canvas.addImage(image1);
    }
}