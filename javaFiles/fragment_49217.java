#Download and silent install JDK

#Working directory path
Write-Host "Creating temp working directory..."
$workd = "c:\temp"

#Check if work directory exists if not create it
If (!(Test-Path -Path $workd -PathType Container))
{ 
    New-Item -Path $workd  -ItemType directory 
}

#Create config file for silent install
Write-Host "Creating config file for silent install..."
$text = '
INSTALL_SILENT=Enable
AUTO_UPDATE=Enable
SPONSORS=Disable
REMOVEOUTOFDATEJRES=1
'
$text | Set-Content "$workd\jdkinstall.cfg"

#Download executable file
Write-Host "Download JDK file to temp directory..."
$source = "https://download.oracle.com/otn-pub/java/jdk/13.0.2+8/d4173c853231432d94f001e99d882ca7/jdk-13.0.2_windows-x64_bin.exe"
$destination = "$workd\jdk-13.0.2_windows-x64_bin.exe"
$client = New-Object System.Net.WebClient
$cookie = "oraclelicense=accept-securebackup-cookie"
$client.Headers.Add([System.Net.HttpRequestHeader]::Cookie, $cookie)
$client.DownloadFile($source, $destination)
Write-Host "Download JDK file completed !"

#Install silently
Write-Host "Trying to install JDK silently..."
Start-Process -FilePath "$workd\jdk-13.0.2_windows-x64_bin.exe" -ArgumentList INSTALLCFG="$workd\jdkinstall.cfg" -Wait
Write-Host "JDK installation completed successfully !"

#Remove the installer
Write-Host "Trying to remove JDK file from temp directory..."
rm -Force $workd\jdk*
Write-Host "JDK file deleted successfully !"