ObjectReader reader = repository.newObjectReader();
CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
oldTreeIter.reset(reader, oldId);
CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
newTreeIter.reset(reader, headId);
List<DiffEntry> diffs= git.diff()
                        .setNewTree(newTreeIter)
                        .setOldTree(oldTreeIter)
                        .call();