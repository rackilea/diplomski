businessTypeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView , View view , int position , long l) {
     businessTypeObj = clubsList.get(position);
                        selectedBusinessTypeList.add(businessTypeObj);
                    }

                }
            });