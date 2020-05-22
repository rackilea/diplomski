case R.id.imageee:
    Intent imageIntent = new Intent(this, Upload.class);
    startActivity(imageIntent);
    return true;
case R.id.pdfff:
    Intent pdfIntent = new Intent(this, Pdf.class);
    startActivity(pdfIntent);
    return true;