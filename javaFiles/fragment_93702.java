if (!checkDatabase()) {
  try {
    if (wantsToInstall()) {
      installDatabase();
    }
  } catch (Exception e) {
    exit();
  }
}