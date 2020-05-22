final class ChartData {

    final Title title;
    final Axis axisY;
    final List<Datum> data;

    ChartData(final Title title, final Axis axisY, final List<Datum> data) {
        this.title = title;
        this.axisY = axisY;
        this.data = data;
    }

}