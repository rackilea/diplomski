@Grab(group='org.apache.commons', module='commons-compress', version='1.4.1')
import org.apache.commons.compress.archivers.zip.*

File jarFile = new File('jarFile.jar')
ZipFile f = new ZipFile(jarFile)
ZipArchiveEntry json = f.getEntry('internalFile.json')
if(json) {
  f.getInputStream(json)?.withStream {
    println it.getText('UTF-8')
  }
}
f.close()
jarFile.delete()