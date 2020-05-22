public string GetDataSet(string sasDirectory, string dataset)
    {
        Common.Log($"Getting SAS dataset ({dataset}) at {sasDirectory}");
        DataTable dt = new DataTable(dataset);
        try
        {
            using (var cn = new OleDbConnection($@"Provider=SAS.LocalProvider; Data Source={sasDirectory}"))
            {
                cn.Open();
                var cmd = cn.CreateCommand();
                cmd.CommandType = CommandType.TableDirect;
                cmd.CommandText = dataset;
                var sas = new OleDbDataAdapter(cmd);
                var ds = new System.Data.DataSet();
                sas.Fill(ds, dataset);
                dt = ds.Tables[0];
                Common.Log($"SAS dataset loaded.");
            }
        }
        catch (Exception ex)
        {
            string errMessage = "Unable to get the SAS dataset. Library: " + sasDirectory + ", DataSet: " + dataset + ", " +
                ex.TargetSite.Name;
            Common.Log($"SAS Error in {MethodBase.GetCurrentMethod().Name}", MessageType.Error, ex);
        }
        return dt.ToCsv('\t');
    }