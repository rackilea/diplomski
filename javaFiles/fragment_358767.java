Drive.Files.Update request = service.files().update(fileId, file, mediaContent);

// set newRevision
request.setNewRevision(newRevision);

// execute
File updatedFile = request.execute();