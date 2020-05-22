switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        switch1.setText(R.string.switchOnWifiEs);
                        wifiManager.setWifiEnabled(true);
                        Toast.makeText(MainActivity.this,R.string.switchingOnWifiEs,Toast.LENGTH_SHORT).show();                 
                    }
                    else{
                        switch1.setText(R.string.swtichOffWifiEs);
                        wifiManager.setWifiEnabled(false);
                        Toast.makeText(MainActivity.this,R.string.switchingOffWifiEs,Toast.LENGTH_SHORT).show();
                    }
final Fragment currentFragment = getFragmentManager().findfragmentId(R.id.container);
if(currentFragment instance HomeFragment){
((HomeFragment)currentFragment).switchClicked(isChecked);
}


                }
            });