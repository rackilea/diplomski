public String getimage(String device)
{
    try{
        Process p = Runtime.getRuntime().exec("scanimage --resolution=300 -l 0 -t 0 -y 297 -x 210 --format png --device-name " + device);
        InputStream in = p.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[8*1024];
        int bytesRead, totalbytes = 0;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        String result = Base64.getEncoder().encodeToString(out.toByteArray());
        out.close();
        p.waitFor();
        p.destroy();
        in.close();
        return result;
    } catch (IOException e) {
        return  e.getLocalizedMessage();
    } catch (InterruptedException e) {
        return  e.getLocalizedMessage();
    }
}