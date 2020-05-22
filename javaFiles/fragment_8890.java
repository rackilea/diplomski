Get-AzureVMImage | where { $_.ImageFamily -like "*ubuntu*14.04*" } | Sort-Object PublishedDate | Format-List ImageFamily, ImageName

...
ImageFamily : Ubuntu Server 14.04 LTS
ImageName   : b39f27a8b8c64d52b05eac6a62ebad85__Ubuntu-14_04_1-LTS-amd64-server-20140927-en-us-30GB

ImageFamily : Ubuntu Server 14.04 LTS
ImageName   : b39f27a8b8c64d52b05eac6a62ebad85__Ubuntu-14_04_1-LTS-amd64-server-20141125-en-us-30GB

ImageFamily : Ubuntu Server 14.04 LTS
ImageName   : b39f27a8b8c64d52b05eac6a62ebad85__Ubuntu-14_04_1-LTS-amd64-server-20150123-en-us-30GB
...