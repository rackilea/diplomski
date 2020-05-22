if (dashModel.getDashIsBookmarked().equalsIgnoreCase("0")) {
                dashModel.setDashIsBookmarked("1");
                Log.e("imgchange", " imgchange");
                dashHolder.bookmark_img.setImageResource(R.drawable.bookmark);
                Map<String, String> params = new HashMap<String, String>();
                params.put("candidate_id", SessionStores.getBullHornId(c));
                params.put("joborder_id", dashModel.getDashId());
                //new BookMarkTaskAdd(c, params);
                notifyDataSetChanged();
            }
            if (dashModel.getDashIsBookmarked().equalsIgnoreCase("1")) {
                dashModel.setDashIsBookmarked("0");
                Log.e("imgchange", " imgchange");
                dashHolder.bookmark_img.setImageResource(R.drawable.blue_tag_img);
                Map<String, String> params = new HashMap<String, String>();
                params.put("candidate_id", SessionStores.getBullHornId(c));
                params.put("joborder_id", dashModel.getDashId());
               // new BookMarkTaskDelete(c, params);
                notifyDataSetChanged();
            }