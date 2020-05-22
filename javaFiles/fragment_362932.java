try {
     String name = "Name: ";
     String dmg = "Damage: ";
     String type = "Ammo Type: "; 
     int count = 0;

    while(resultset.next){
        count++

       if(count == 1){
            weapon1.setText(name+resultset.getString("weapons"));
            weapon1dmg.setText(dmg+resultset.getString("weaponDMG"));
           weapon1type.setText(type+resultset.getString("weaponAmmoType"));
      }else if(count == 2){
            weapon2.setText(name+resultset.getString("weapons"));
            weapon2dmg.setText(dmg+resultset.getString("weaponDMG"));
            weapon2type.setText(type+resultset.getString("weaponAmmoType"));

      }else if(count == 3)
            weapon3.setText(name+resultset.getString("weapons"));
            weapon3dmg.setText(dmg+resultset.getString("weaponDMG"));
            weapon3type.setText(type+resultset.getString("weaponAmmoType"));
    }