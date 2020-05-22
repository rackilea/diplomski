ISchedulingRule rule = ...;
try {
  jobManager.beginRule( rule, monitor );
  if( project.exists() ) {
    // read or write project preferences
  }
} finally {
  jobManager.endRule( rule );
}