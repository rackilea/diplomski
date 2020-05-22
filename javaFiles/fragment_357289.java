@RequestMapping(value = "/users/getProfilePic/{uniqueId}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getProfilePic(@PathVariable long uniqueId) {

        try{ 
            //reading image from tomcat folder you can read from the place where you stored the images
            String rootPath = System.getProperty("catalina.home");
            String profilePicDirectory = rootPath + File.separator + "profilePictures" + File.separator  + uniqueId;
            String profilePicFile = profilePicDirectory +  File.separator + uniqueId +".jpg";

            RandomAccessFile f = new RandomAccessFile(profilePicFile, "r");
            byte[] b = new byte[(int)f.length()];
            f.readFully(b);
            f.close();
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<byte[]>(b, headers, HttpStatus.OK);
        }catch(Exception ex){
            //ex.printStackTrace();
            final HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<byte[]>(null, headers, HttpStatus.NOT_FOUND);
            //return null;
        }
    }