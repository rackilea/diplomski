else
     {
         viewHolder = (ViewHolder) convertView.getTag();
     }

// ADD THIS TWO LINES
viewHolder.sms_from_row.setVisibility(View.Visible);
viewHolder.sms_to_row.setVisibility(View.Visible);

     if(Constant_Variables.Sms_Status_list.get(position).equalsIgnoreCase(Twilioresponse_Utils.sms_sent))
     {