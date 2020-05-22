for (int i=0; i<BrowserFiles.selectedItems.size(); i++) {
            if (BrowserFiles.selectedItems.get(i).GetPosition() == position) {

                v.setBackgroundColor(Color.rgb(255, 165, 0));
                if (convertView != null)
                    convertView.setBackgroundColor(Color.rgb(255, 165, 0));
                break;
            }
        }