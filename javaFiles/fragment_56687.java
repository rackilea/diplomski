public class DownloadFile implements Comparable<DownloadFile>{

    String filename;

    DownloadFile(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    @Override
    public String toString() {
        return this.getFilename();
    }

    @Override
    public int compareTo(DownloadFile downloadFile) {
        String thisStr = this.filename.toLowerCase();
        String oStr = downloadFile.getFilename().toLowerCase();
        if(thisStr.endsWith(".rar")) {
            if(!oStr.endsWith(".rar"))
                return -1;
        }
        if(oStr.endsWith(".rar")) {
            if(!thisStr.endsWith(".rar"))
                return 1;
        }
        if(thisStr.matches(".*\\.r[0-9]{2,}$")) {
            if(!oStr.matches(".*\\.r[0-9]{2,}$"))
                return -1;
        }
        if(oStr.matches(".*\\.r[0-9]{2,}$")) {
            if(!thisStr.matches(".*\\.r[0-9]{2,}$"))
                return 1;
        }
        if(thisStr.endsWith(".par2")) {
            if(!oStr.endsWith(".par2"))
                return -1;
        }
        if(oStr.endsWith(".par2")) {
            if(!thisStr.endsWith(".par2"))
                return 1;
        }
        return thisStr.compareTo(oStr);
    }

    public static void main(String[] args) {
        List<DownloadFile> fileList = new ArrayList<>();
        fileList.add(new DownloadFile("a.rar"));
        fileList.add(new DownloadFile("b.rar"));
        fileList.add(new DownloadFile("a.r01"));
        fileList.add(new DownloadFile("b.r01"));
        fileList.add(new DownloadFile("a.r10"));
        fileList.add(new DownloadFile("b.r10"));
        fileList.add(new DownloadFile("a.par2"));
        fileList.add(new DownloadFile("b.par2"));
        fileList.add(new DownloadFile("a.other"));
        fileList.add(new DownloadFile("b.other"));
        Collections.shuffle(fileList);
        Collections.sort(fileList);
        System.out.println(fileList);
    }
}