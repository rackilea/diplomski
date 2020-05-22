if(name.equals("Inbox")){
                        categoryMode1= new CategoryModel(itemData,name,R.drawable.ic_inbox, itemCount);
                    }else if(name.equals("Stared")){
                        categoryMode1= new CategoryModel(itemData,name,R.drawable.ic_stars, itemCount);
                    }else{
                        categoryMode1= new CategoryModel(itemData,name,R.drawable.ic_inbox, itemCount);
                    }

                    mainData.add(categoryMode1);
                    mainAdapter.notifyDataSetChanged();`