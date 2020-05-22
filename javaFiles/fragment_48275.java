<android.support.v7.widget.RecyclerView
    android:id="@+id/contractors_recyclerView"
    android:layout_width="0dp"
    android:layout_height="0dp"
    android:layout_marginEnd="16dp"
    android:layout_marginStart="16dp"
    app:contractorItems="@{viewmodel.contractors}"
    tools:listitem="@layout/contractor_signature_item" />