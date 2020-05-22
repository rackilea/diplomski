btn_send_msg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String millisInString  = dateFormat.format(new Date());

        Map<String,Object> map = new HashMap<String, Object>();
        temp_key = root.push().getKey();
        root.updateChildren(map);

        DatabaseReference message_root = root.child(temp_key);
        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("name",user_name);
        map2.put("msg",input_msg.getText().toString()+millisInString);


        message_root.updateChildren(map2);
    }
});