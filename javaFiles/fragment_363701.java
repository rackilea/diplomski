try 
        {
            boolean hasResults = statement.execute(_stmt);

            do { //I think... this could only possibly get one result. FIXME

            if (hasResults) 
            {
                try(ResultSet rs = statement.getResultSet())
                {
                    CachedRowSetImpl crs = new CachedRowSetImpl();
                    crs.populate(rs);

                    return crs;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            hasResults = statement.getMoreResults();

            } while (hasResults || statement.getUpdateCount() != -1);

            } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            statement.close();
        }