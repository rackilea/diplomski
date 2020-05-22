fs.setOnCloseRequest(e->{
    if (fs.getResult() != null) {
        category1.setStyle(null);
        category1.setFont(fs.getResult());
    }
});