enum Actions {
  OPEN_MEDICAL_FILE
  ...
}

void handleRequest(...) {
  String patient = ...;
  Audit audit = new Audit(OPEN_MEDICAL_FILE);
  audit.addParameter("patient", patient);
  try {
     ... more things ..
     audit.addParameter("file", "#001");
     ... more things ...
     audit.setSuccess();
  } finally {
    audit.save();
  }
}