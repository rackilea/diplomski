/**
   * Reads an array of data from the provided NetCDF variable. If the variable is a member of a structure, that member is read
   * from all the structures in the array and returned as a single array containing that member from each structure.
   * @param variable The NetCDF variable to read.
   * @param section The section indicating the element of the array to read
   * @param indexEnd The ending source index, exclusive, or -1 if all available values should be read.
   * @return An array representing the requested range of values read for the given variable.
   * @throws IOException if there is an error reading the data.
   */
  public static Array readArray(final Variable variable, final Section section) throws IOException, InvalidRangeException {
    if (variable.isMemberOfStructure()) { //if the variable is member of a structure
      final Structure parentStructure = variable.getParentStructure().select(variable.getShortName()); //select just the member variable
      final ArrayStructure arrayStructure = (ArrayStructure) parentStructure.read(section); //read the array of structures
      return arrayStructure.extractMemberArray(arrayStructure.findMember(variable.getShortName())); //extract just the member into an array
    } else { //if the variable is not a member of a structure
      return variable.read(section); //just read the section directly from the variable
    }
  }