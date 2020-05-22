private String titulo;
private String dataY;
private String chartDataTic;
private String chartDataComp;
private String chartDataImpr;
private String chartDataComu;
private BigDecimal miny;

public void initChart() throws Exception {

titulo = "My Chart Title";
dataY = "5, 20, 36, 10, 10, 20";
this.miny = new BigDecimal(100);

List<BigDecimal> listaValoresTic = new ArrayList<>();
List<BigDecimal> listaValoresComp = new ArrayList<>();
List<BigDecimal> listaValoresImpr = new ArrayList<>();
List<BigDecimal> listaValoresComu = new ArrayList<>();

List<String> listaX = new ArrayList<>();

try {
    List<DisponibilidadHistorico> dhs = this.eJBController.getDisponibilidadEJB().disponibilidadHistPorSemanas(8);
    for (int i = 0; i < dhs.size(); i++) {
        DisponibilidadHistorico get = dhs.get(i);
        listaValoresTic.add(get.getDispTics());
        listaValoresComp.add(get.getDispComp());
        listaValoresImpr.add(get.getDispImpr());
        listaValoresComu.add(get.getDispComu());

        listaX.add(utilMB.toStringfechaDatosSemana(get.getFecha()));
        if (this.miny.compareTo(get.getDispComp()) == 1) {
            this.miny = get.getDispComp();
        }
        if (this.miny.compareTo(get.getDispComp()) == 1) {
            this.miny = get.getDispComp();
        }
        if (this.miny.compareTo(get.getDispImpr()) == 1) {
            this.miny = get.getDispImpr();
        }
        if (this.miny.compareTo(get.getDispComu()) == 1) {
            this.miny = get.getDispComu();
        }

    }

    setChartDataTic(new Gson().toJson(listaValoresTic));
    setChartDataComp(new Gson().toJson(listaValoresComp));
    setChartDataImpr(new Gson().toJson(listaValoresImpr));
    setChartDataComu(new Gson().toJson(listaValoresComu));
    setChartSerie(new Gson().toJson(listaX));
} catch (Exception e) {
}