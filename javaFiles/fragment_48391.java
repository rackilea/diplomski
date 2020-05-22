[...]
    BufferedReader input = null;
    try {
        URL url = new URL(updateUrl);
        input = new BufferedReader(new InputStreamReader(url.openStream()));
[...]
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
    } finally {
        if (input != null)
        {
            try {
              input.close();
            }
            catch (IOException exc)
            {
              exc.printStackTrace();
            }
        }
    }
[...]