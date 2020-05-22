String abcd = "4,0,1581664239228,6,799,0,845,253,0,0,0,0,0,0,0,0,0,0,1448,594,0,1276257,0,0,0,0,1100,0,0,0,0,0,0,0,2047,2158,0,13,1";
   String valueName = "version,build,tuneStartBaseUTCMS,ManifestDLStartTime,ManifestDLTotalTime,ManifestDLFailCount,VideoPlaylistDLStartTime,VideoPlaylistDLTotalTime,VideoPlaylistDLFailCount,AudioPlaylistDLStartTime,AudioPlaylistDLTotalTime,AudioPlaylistDLFailCount,VideoInitDLStartTime,VideoInitDLTotalTime,VideoInitDLFailCount,AudioInitDLStartTime,AudioInitDLTotalTime,AudioInitDLFailCount,VideoFragmentDLStartTime,VideoFragmentDLTotalTime,VideoFragmentDLFailCount,VideoBitRate,AudioFragmentDLStartTime,AudioFragmentDLTotalTime,AudioFragmentDLFailCount,AudioBitRate,drmLicenseAcqStartTime,drmLicenseAcqTotalTime,drmFailErrorCode,LicenseAcqPreProcessingDuration,LicenseAcqNetworkDuration,LicenseAcqPostProcDuration,VideoFragmentDecryptDuration,AudioFragmentDecryptDuration,gstPlayStartTime,gstFirstFrameTime,contentType,streamType,firstTune";

   String[] list1 = abcd.split(",");
   String[] list2 = valueName.split(",");

   if (list1.length == list2.length) {

       for (int x = 0; x < list1.length; x++) {
           System.out.println(list2[x] + ":" + list1[x]);
       }
   }