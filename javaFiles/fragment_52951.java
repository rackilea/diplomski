List<String> savedLocations = new ArrayList<>();

for (Tiedosto tiedosto : tiedostoList) {
    Attachment attachment = new Attachment();
    attachment.setCustomerId(tiedosto.getCustomerId());
    attachment.setSize(tiedosto.getFileSize());

    CreationReceipt<Attachment> receipt = attachmentService.createNew(attachmentToSave);
    savedLocations.add(receipt.getLocation());
}

// Do something with savedLocations