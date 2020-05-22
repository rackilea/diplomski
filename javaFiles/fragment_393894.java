boolean flag = false;

if(someBoolean){
  jLbl_show0.setIcon(new ImageIcon(getClass().getResource("/img/wrong.png")));
  flag = true;
}
else{
  jLbl_show0.setIcon(new ImageIcon(getClass().getResource("/img/ok.png")));
}

if(flag){something}
else{something}