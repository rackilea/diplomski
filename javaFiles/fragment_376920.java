RevCommit commit;
try( RevWalk revWalk = new RevWalk( repository ) ) {
  commit = revWalk.parseCommit( oid );
}

git.notesShow().setObjectId( commit )...