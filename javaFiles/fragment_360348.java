public Set<String> getSpamPhoneNumbers() {
    synchronized(spamPhoneNumbers) {
      if(timestamp - System.currentTimeMillis() > ONE_WEEK) {
        updateSpamPhoneNumbers();
      }
    }
    return spamPhoneNumbers;
  }

  private void updateSpamPhoneNumbers() {
    Set<String> newSpamPhoneNumbers = new HashSet<>();
      //populate set from file on server
      spamPhoneNumbers = Collections.unmodifiableSet(newSpamPhoneNumbers);
      timestamp = System.currentTimeMillis();
  }