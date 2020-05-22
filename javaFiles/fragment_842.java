recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapterClass(getContext(), lst);
        recyclerView.setAdapter(mAdapter);





<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.iosdteachingapp.MainActivity">
<LinearLayout
    android:layout_width="match_parent"
    android:orientation="vertical"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="100sp"
        android:text="hello"/>
    <android.support.v7.widget.RecyclerView
        android:id="@+id/my_recycler_view"
        android:layout_width="200sp"
        android:layout_height="300sp" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="end"
        android:padding="20sp"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="end"
        android:padding="20sp"/> <TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="end"
    android:padding="20sp"/> <TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="end"
    android:padding="20sp"/>
</LinearLayout>
</ScrollView>