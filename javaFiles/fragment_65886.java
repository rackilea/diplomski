private ISODate start_time;
private ISODate end_ocr_time;
private ISODate end_addr_time;
private ISODate end_oper_time;
class ISODate {
    private Date $date;
    ISODate() {
        $date = new Date(0);
    }
    public Date get$date() {
        return $date;
    }
}