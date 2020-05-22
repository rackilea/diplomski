public void run() {
try {
    unzipFolder(this.getZipFile());
    complete=true;
} catch (IOException ex) {
    Logger.getLogger(Unzipper.class.getName()).log(Level.SEVERE, null, ex);
}
}

//simple getter.
public boolean isComplete()
{
    return this.complete;
}