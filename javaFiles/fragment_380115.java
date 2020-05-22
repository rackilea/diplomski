switch (rowType) {
            case TYPE_ITEM:
                if (convertView == null) {
                   ...
                } else {
                    holder = (ViewHolder) convertView.getTag();
-->                    SET HERE YOUR VIEWS VALUES!
                }
                break;
            case TYPE_SEPARATOR:
                if (convertView == null) {
                   ...
                } else {
                    TextView category=(TextView) convertView.getTag();
-->                    SET HERE YOUR VIEWS VALUES!
                }
                break;
        }