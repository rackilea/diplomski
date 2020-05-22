@Override
public void onCreate(SQLiteDatabase db) {
    String crt_setTicketAvailability_trigger = "CREATE TRIGGER IF NOT EXISTS setTicketAvailability " + 
        " AFTER INSERT ON " + customer.Table_Name + 
        " BEGIN UPDATE " + ticket.Table_Name + 
        " SET " + ticket.Col_isBooked + "=1 " + 
        " WHERE " + ticket.Table_Name + "." + ticket.Col_id + 
        " = new." + customer.Col_Ticket_id + ";" + 
        " END";
    db.execSQL(ticket.Create_table);
    db.execSQL(customer.Create_table);
    db.execSQL(crt_setTicketAvailability_trigger);

}