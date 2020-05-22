01: @Transactional
02: public void updatePDBEntry(Set<PDBEntry> pdbEntrySet) {
03:     for (PDBEntry pdbEntry : pdbEntrySet) {
04:         PDBEntry existingEntry = findByAccessionCode(pdbEntry.getAccessionCode());
05:         if (existingEntry != null) {
06:             log.debug("Remove previous version of PDBEntry {}", existingEntry);
07:             makeTransient(existingEntry);
08:         }
09:         makePersistent(pdbEntry);
10:     }
11: }