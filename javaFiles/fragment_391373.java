list.setOnItemDragNDropListener(new DragNDropListener(){
                public void onItemDrop(DragNDropListView parent, View view, int startPosition, int endPosition, long id)
                {
                    super.onItemDrop(parent, view, startPosition, endPosition, id);
                    Log.i("long clicked","pos"+" "+endPosition+" id "+id);
                }

        });