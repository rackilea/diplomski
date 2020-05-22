mHolder.txt_turno.setText(turnoName.get(pos));
     mHolder.txt_ore.setText(oreName.get(pos));
     mHolder.txt_id.setText(dataName.get(pos));

     String Turno = turnoName.get(pos);

mHolder.txt_turno.setTextColor(Color.WHITE);

if (Turno != null){ 
if (TextUtils.equals(Turno,"M"))
          mHolder.txt_turno.setTextColor(Color.RED);

if (TextUtils.equals(Turno,"F"))
      mHolder.txt_turno.setTextColor(Color.YELLOW);
}
return child;