@Service
public class BackupServiceImpl implements BackupService {

    public List<FileInfo> listBackupFiles() {
        // localStorage come from
        // maybe Util has it as static method, else inject it
        return util.listBackupFilesInLocalDir(localStorage);
    }
}