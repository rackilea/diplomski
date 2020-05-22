Uri Download_Uri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(Download_Uri);

            //Restrict the types of networks over which this download may proceed.
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
            //Set whether this download may proceed over a roaming connection.
            request.setAllowedOverRoaming(true);
            //Set the local destination for the downloaded file to a path within the application's external files directory
            String[] split = url.split("/");
            request.setDestinationInExternalFilesDir(activity, null, split[split.length-1]);
            //Set the title of this download, to be displayed in notifications (if enabled).
            request.setTitle("Downloading " + title);
            //Set a description of this download, to be displayed in notifications (if enabled)
            request.setDescription("Downloading " + name);

            request.setVisibleInDownloadsUi(false);

            //Enqueue a new download and get the reference Id
            long downloadReference = downloadManager.enqueue(request);