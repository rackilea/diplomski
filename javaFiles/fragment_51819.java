try
    {
        final Process p = Runtime.getRuntime().exec(String.format("cmd /c %s", query));
        final ProcessResultReader stderr = new ProcessResultReader(p.getErrorStream(), "STDERR");
        final ProcessResultReader stdout = new ProcessResultReader(p.getInputStream(), "STDOUT");
        stderr.start();
        stdout.start();
        final int exitValue = p.waitFor();
        if (exitValue == 0)
        {
            System.out.print(stdout.toString());
        }
        else
        {
            System.err.print(stderr.toString());
        }
    }
    catch (final IOException e)
    {
        throw new RuntimeException(e);
    }
    catch (final InterruptedException e)
    {
        throw new RuntimeException(e);
    }