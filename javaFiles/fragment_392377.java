....
if ($Java_GUIDS -contains $Installed_GUID)
{
    Write-Host "Found $Installed_GUID in Java GUIDS Array.  Removing..."

    #Defining the command here to make it clean. One object per word (split at whitespace).
    $argumentlist = @('/x', $Installed_GUID, '/qn', '/norestart', '/l*v', '"C:\Windows\TEMP\Java Removal.log"')
    Start-Process -FilePath msiexec.exe -ArgumentList $argumentlist -Wait

    Write-Host "Done"
}
....