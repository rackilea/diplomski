else if (e.getSource()==calcul1){
        Date date1 = (Date) datePicker3.getDate();
        DateTime dt1 = new DateTime(date1);

        if ( ajout.isSelected()){

        dt1 = dt1.plusYears((Integer)anlist.getValue());
        dt1 = dt1.plusMonths((Integer)moilist.getValue());
        dt1 = dt1.plusDays((Integer)jourlist.getValue());
        }
        if (soustr.isSelected()){
            dt1 = dt1.minusYears((Integer)anlist.getValue());
            dt1 = dt1.minusMonths((Integer)moilist.getValue());
            dt1 = dt1.minusDays((Integer)jourlist.getValue());
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern("EEEE dd MMMM yyyy");
        textdate.setText(formatter.print(dt1));
    }