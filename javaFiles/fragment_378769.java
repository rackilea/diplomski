File w_inf_src = new File(p_filepath);
String encoding = StandardCharsets.UTF_8.name();
String w_disposition = String.format("%s;filename=\"%3$s\"; filename*=%2$s''%3$s",
    Part.ATTACHMENT,
    encoding,
    URLEncoder.encode(p_filename, encoding).replace("+", "%20"));

p_response.setContentType(w_mime);
p_response.setContentLengthLong(w_inf_src.length());
p_response.setCharacterEncoding(encoding);
p_response.setHeader("Content-Disposition", w_disposition);

byte[] w_buffer = new byte[p_response.getBufferSize()];
try(FileInputStream w_inf = new FileInputStream(w_inf_src);
    OutputStream w_outf = p_response.getOutputStream())
{
    int n;
    while((n = w_inf.read(w_buffer)) != -1)
    {
        w_outf.write(w_buffer, 0, n);
    }
}