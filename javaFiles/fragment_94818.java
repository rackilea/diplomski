<application>
        <provider
        android:name="android.support.v4.content.FileProvider"
        android:grantUriPermissions="true"
        android:exported="false"
        android:authorities="${applicationId}">

        <meta-data
            android:name="android.support.FILE_PROVIDER_PATHS"
            android:resource="@xml/file_provider_paths"/>

    </provider>

</application>