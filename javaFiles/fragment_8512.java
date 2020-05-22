newref.addChildEventListener(object: ChildEventListener {
            override fun onChildChanged(snap: DataSnapshot, p1: String?) {
                Log.d("ac1234","${snap}")
            }


            override fun onCancelled(p0: DatabaseError) {           }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {            }


            override fun onChildAdded(p0: DataSnapshot, p1: String?) {  }

            override fun onChildRemoved(p0: DataSnapshot) {  }

        })