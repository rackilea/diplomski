<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${packageName}.${activityClass}" >

    <TextView
        android:id="@+id/tvTi"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        android:textSize="30dp" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/tvTi"
        android:layout_marginTop="36dp"
        android:text="nameCaptureNo"
        android:textAppearance="?android:attr/textAppearanceSmall" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/textView1"
        android:layout_marginTop="32dp"
        android:text="nameCaptureUz"
        android:textAppearance="?android:attr/textAppearanceSmall" />

    <EditText
        android:id="@+id/nameCaptureUz"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/textView3"
        android:layout_alignBottom="@+id/textView3"
        android:layout_alignLeft="@+id/nameCaptureNo"
        android:layout_marginLeft="16dp"
        android:ems="10" />

    <Button
        android:id="@+id/send"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_below="@+id/nameCaptureUz"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="30dp"
        android:text="Send" />

    <EditText
        android:id="@+id/nameCaptureNo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@+id/textView1"
        android:layout_alignBottom="@+id/textView1"
        android:layout_alignParentRight="true"
        android:ems="10" />

</RelativeLayout>