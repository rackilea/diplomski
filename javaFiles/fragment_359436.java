<html> 
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
  </head> 
  <body> 
  <h3>refresh the page after you've submitted to see your new image</h3>
    <div style="width:300px">
    <form action="http://s3.amazonaws.com/dev.sente" method="post" enctype="multipart/form-data"> 
      <fieldset>
      <input type="hidden" name="acl" value="public-read" /> <br /> 
      <i>name of key:</i><input type="text" name="key" readonly="true" value="image.jpg" /> <br /> 
      <input name="file" type="file" /> <br /> 
      <input name="submit" value="Upload" type="submit" /> 
    </fieldset>
    </form> 
  </div>
    <br />
    <a href="http://s3.amazonaws.com/dev.sente/image.jpg">http://s3.amazonaws.com/dev.sente/image.jpg</a><br />
      <a href="http://s3.amazonaws.com/dev.sente/image.jpg"><img src="http://s3.amazonaws.com/dev.sente/image.jpg" /></a>
    </a>
  </body> 
</html>