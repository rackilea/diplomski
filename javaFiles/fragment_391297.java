try{
        Date date = sdf.parse(value);
        try
        {
            Date dat = sdf.parse(valu);
            long diff = dat.getTime() - date.getTime();
            tv.setText(String.valueOf(diff));
        }
        catch(ParseException f)
        {
            f.printStackTrace();
        }
        finally
        {}
    }
    catch(ParseException f)
    {
        f.printStackTrace();
    }
    finally
    {}