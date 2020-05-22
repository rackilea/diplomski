function Unzip-File($file) {    
    $path = [io.path]::GetDirectoryName($file.FullName)
    $filename = [io.path]::GetFileNameWithoutExtension($file.FullName)
    $targetPath = Join-Path $path $filename;

    # Check if the directory exists.    
    if(Test-Path $targetPath) {
        # Remove the directory before unzipping.
        Remove-Item $targetPath -recurse
    }

    # Unzip file.
    Add-Type -A System.IO.Compression.FileSystem
    [IO.Compression.ZipFile]::ExtractToDirectory($file, $targetPath)
}