downloadPage=$(wget -q -O- http://www.oracle.com/technetwork/java/javase/downloads/index.html | grep -o -E 'server-jre8-downloads-[^"]+.html')
echo Prüfe ${downloadPage} auf Download-Link
#downloadUrl=$(wget -q -O- http://www.oracle.com/technetwork/java/javase/downloads/${downloadPage} | grep -o -E "http.+/server-jre.+linux-x64.tar.gz" | head -1)
downloadUrl=$(wget -q -O- http://www.oracle.com/technetwork/java/javase/downloads/${downloadPage} | grep -o -E 'http[^"]+/server-jre[^"]+linux-x64.tar.gz' | head -1)

echo Download von ${downloadUrl}
downloadFileName=$(echo ${downloadUrl} | cut -d'/' -f9)
echo Dateiname ${downloadFileName}
version=$(echo ${downloadFileName} | cut -d'-' -f3 | cut -d'u' -f2)
echo Update-Version ${version}

tarDir=/usr/local/src

wget -P $tarDir --no-check-certificate --header='Cookie: oraclelicense=accept-securebackup-cookie' ${downloadUrl}