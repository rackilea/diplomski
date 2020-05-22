switch (entry.getEntryKind()) {
    case IClasspathEntry.CPE_LIBRARY: {
        String name = entry.getPath().segment(0);
        /* Further processing for a Library
        *...
        */
        break;              
        }
    case IClasspathEntry.CPE_PROJECT: {
        String name = entry.getPath().segment(0);
        /* Further processing for a Project
        *...
        */
        break;
    }