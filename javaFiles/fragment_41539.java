/**
   * Sets the Pact File for the consumer
   * @param file Pact file, either as a string or a PactSource
   * @deprecated Use setPactSource instead
   */
  @Deprecated
  void setPactFile(def file) {
    if (file instanceof PactSource) {
      pactSource = file
    } else {
      pactSource = new FileSource(file as File)
    }
  }

  /**
   * Returns the Pact file for the consumer
   * @deprecated Use getPactSource instead
   */
  @Deprecated
  def getPactFile() {
    pactSource
  }