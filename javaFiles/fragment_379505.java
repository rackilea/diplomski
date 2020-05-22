public class FileModifiedComparator implements Comparator<FileSystemResource>{

        @Override
        public int compare(FileSystemResource file1, FileSystemResource file2) {
       //comparing based on last modified time
            return Long.compare(file1.lastModified(),file2.lastModified());
        }
 }