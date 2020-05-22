ObjectReader reader = repository.newObjectReader();
CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
oldTreeIter.reset(reader, oldHead);
CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
newTreeIter.reset(reader, head);
List<DiffEntry> diffs= git.diff()
                    .setNewTree(newTreeIter)
                    .setOldTree(oldTreeIter)
                    .call();