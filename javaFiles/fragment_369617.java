public static void main(String[] argsk) {
    // GET DATA FROM ARGS
    String _test = "NRT USAGE TREND;TANGGAL;ROWCOUNT;2;EMP;HIVE;0:20|1:300|2:200;0:20|1:30|2:200";
    String[] args = _test.split(";");
    DataChart DC = new DataChart();
    DC.Title = args[0];
    DC.LabelX = args[1];
    DC.LabelY = args[2];
    DC.JumlahSeries = Integer.parseInt(args[3]);
    DC.Datas = new ArrayList<DataSeries>();
    for(int i = 1; i <= DC.JumlahSeries; i++)
    {
        DataSeries DS = new DataSeries();
        DS.NamaSeries = args[3+i];
        DS.Data = new ArrayList<dataXY>();
        String[] _data = args[3+DC.JumlahSeries+i].split("\\|");
        for(int k = 0; k < _data.length; k++)
        {
            dataXY a = new dataXY();
            a.X = Double.parseDouble((_data[k].split(":"))[0]);
            a.Y = Double.parseDouble((_data[k].split(":"))[1]);
            DS.Data.add(a);
        }
        DC.Datas.add(DS);
    }
    Grafik = DC;
    launch(args); 
}