import urllib2
import MultipartPostHandler

params = {'file':open( "FILENAME.JPG" , 'rb')}
opener = urllib2.build_opener(MultipartPostHandler.MultipartPostHandler)
urllib2.install_opener(opener)
req = urllib2.Request( "PROCESS.PHP" , params)
text_response = urllib2.urlopen(req).read().strip()