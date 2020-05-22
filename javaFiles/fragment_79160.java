{
   "scrape_configs": [
      {
         "job_name": "sampleName",
         "scrape_timeout": "10s",
         "scrape_interval": "10s",
         "metrics_path": "samplePath",
         "file_sd_configs": [
            {
               "files": [
                  "sampleFile"
               ]
            }
         ]
      }
   ]
}