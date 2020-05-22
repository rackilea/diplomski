for (Category category : produkListResponse.getListProduk())
                {
                    Bundle bundle = new Bundle(); //I guess you're missing this
                    bundle.putInt("category",category.getId());

                    deskripsi=new FragmentKonten();
                    deskripsi.setArguments(bundle);

                    adapter.addFragment(deskripsi,category.getTitle());
                    adapter.notifyDataSetChanged();
                }