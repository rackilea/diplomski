case R.id.addBtn:
      String name = et.getText().toString();
      try {
         dbcon.insertVestiging(groupd, name);
       }catch(SQLiteException e) {
          e.printStackTrace();
       }
    Intent main = new Intent(Add_vestiging.this, vestiging_list.class);
    main.putExtra("groupID", String.valueOf(groupd));
    startActivity(main);
    break;