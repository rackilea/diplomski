public  View  getView(int position, View convertView, ViewGroup parent) {
if(position==1){//please check position is start from 0 or 1
//do nothing
}
else{
//paste all code here
 RelativeLayout container ;
//      Log.d(TAG,"GetView. ConvertView "+position+" of "+ Broker.model.issueFilter.issueShowingList().size());
        if (Broker.model.issueFilter.issueShowingList().size()<= position  ) return null;
        if (convertView == null) { 
//          Log.d(TAG,"GetView. ConvertView is null");
            container = new RelativeLayout(mContext);

            IRIssue theIssue = Broker.model.issueFilter.issueShowingList().get(position);   
            final int clickedPosition = position;

            ImageButton coverImage = new ImageButton(mContext); 
            coverImage.setId(plastic_randomNum + position);
            coverImage.setPadding(5,3,6,7);
            coverImage.setBackgroundDrawable(null);

            if(theIssue.thumbLocation==null ){
                coverImage.setImageResource(R.raw.default_thumbnail);   
            }else{
                if(new File(theIssue.thumbLocation).exists()){
                    coverImage.setImageURI( Uri.parse(theIssue.thumbLocation)); 
                    if (coverImage.getDrawable()==null){
                        coverImage.setImageResource(R.raw.default_thumbnail);
                    }           
                }else{
                    coverImage.setImageResource(R.raw.default_thumbnail);   
                }}
            Log.d(TAG,"successfully get thumb");
            RelativeLayout.LayoutParams imgparam;
            DisplayMetrics outMetrics = new DisplayMetrics();
            Broker.listViewActivity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);

            float expectedHeight = 240 / ((float)coverImage.getDrawable().getMinimumWidth()/(float)coverImage.getDrawable().getMinimumHeight());
            int   expectedWidth = 240;

            if (outMetrics.densityDpi==DisplayMetrics.DENSITY_XHIGH || outMetrics.densityDpi==DisplayMetrics.DENSITY_XXHIGH){
                 expectedWidth = 240;
                 imgparam = new RelativeLayout.LayoutParams(240, (int)expectedHeight);

            }else{
                 expectedWidth = 200;
                imgparam = new RelativeLayout.LayoutParams(expectedWidth, RelativeLayout.LayoutParams.WRAP_CONTENT);
            }
            imgparam.addRule(RelativeLayout.ALIGN_PARENT_TOP, coverImage.getId());
            imgparam.addRule(RelativeLayout.CENTER_HORIZONTAL, coverImage.getId());
            imgparam.setMargins(10, 20, 10, 0);
            coverImage.setLayoutParams(imgparam);
            coverImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            coverImage.setAdjustViewBounds(true);
            coverImage.setOnClickListener( new OnClickListener(){
                public void onClick(View arg0) {
                    Broker.listViewActivity.ItemClick(clickedPosition);
                }     });  
            coverImage.setLongClickable(true);
            coverImage.setOnLongClickListener( new OnLongClickListener(){
                public boolean onLongClick(View arg0) {
                    Broker.listViewActivity.ItemLongClick(clickedPosition);
                    return true;
                }     });  
            Log.d(TAG,"Image Created");

            RelativeLayout.LayoutParams relativeParams;
            if (outMetrics.densityDpi==DisplayMetrics.DENSITY_XHIGH || outMetrics.densityDpi==DisplayMetrics.DENSITY_XXHIGH){
                relativeParams = new RelativeLayout.LayoutParams(expectedWidth, 80);    
            }else{
                relativeParams = new RelativeLayout.LayoutParams(expectedWidth, RelativeLayout.LayoutParams.WRAP_CONTENT);
            }
            TextView caption = new TextView(mContext);
            relativeParams.addRule(RelativeLayout.ALIGN_RIGHT, coverImage.getId());
            relativeParams.addRule(RelativeLayout.BELOW, coverImage.getId());
            relativeParams.setMargins(0, 0, 0, 10);
            caption.setId(plastic_iconNum+position);
            caption.setTextColor(Color.BLACK);
            caption.setTypeface(null,Typeface.BOLD);
            caption.setTextSize(16);
            caption.setGravity(Gravity.CENTER_HORIZONTAL);
            caption.setText(theIssue.issueNo);
            caption.setLayoutParams(relativeParams);
            int iconSize = 24;
            int iconMargin = 0;
            if (outMetrics.densityDpi==DisplayMetrics.DENSITY_XHIGH || outMetrics.densityDpi==DisplayMetrics.DENSITY_XXHIGH){ 
                iconSize = 36;
                iconMargin = 5;
            }
            relativeParams = new RelativeLayout.LayoutParams(iconSize, iconSize);

            ImageView statusIcon = new ImageView(mContext);
            relativeParams.addRule(RelativeLayout.ALIGN_LEFT, coverImage.getId());
            relativeParams.addRule(RelativeLayout.ALIGN_TOP, caption.getId());
            relativeParams.setMargins(0, iconMargin, 5, 0);
            statusIcon.setLayoutParams(relativeParams);

            statusIcon.setAdjustViewBounds(false);
            switch (theIssue.status){
            case NoDownload:
                statusIcon.setImageResource(R.raw.btn_media_null);
                break;
            case Downloading:
            case DownloadStopped:
                statusIcon.setImageResource(R.raw.icon_downloading);
                break;
            case DownloadedAndExtracted:
                statusIcon.setImageResource(R.raw.icon_downloaded);
                break;
            default:
                statusIcon.setImageResource(R.raw.btn_media_null);
            }

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(50,50);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, coverImage.getId());

            ProgressBar queue = new ProgressBar(mContext,null, android.R.attr.progressBarStyleLarge);
            queue.setLayoutParams(layoutParams);
            if (Broker.model.downloadQueue.isItQueued(theIssue.pubKey))
                queue.setVisibility(View.VISIBLE);
            else 
                queue.setVisibility(View.INVISIBLE);

            layoutParams = new RelativeLayout.LayoutParams(160,10);
            layoutParams.setMargins(0, 0, 0, 10);
            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, coverImage.getId());
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, coverImage.getId());

            AkaProgressBar progress = new AkaProgressBar(mContext);
//          if (theIssue.status==IRConstant.IssueVolumeStatus.DownloadStopped && IRProcess.isDownloading==null) 
//              progress.setProgress(0); 
//          else 
            if (theIssue.vol[0].pageCount != 0)
                progress.setProgress(Math.round(((float)theIssue.progress / theIssue.vol[0].pageCount) * 10000));
            progress.setLayoutParams(layoutParams);

            if (theIssue.status==IRConstant.IssueVolumeStatus.Downloading  ) 
                progress.setVisibility(View.VISIBLE);
            else 
                progress.setVisibility(View.INVISIBLE);

            container.addView(coverImage); 
            container.addView(statusIcon);
            container.addView(progress);
            container.addView(caption);
            container.addView(queue);

        }else{
//          Log.d(TAG,"GetView. ConvertView is not null");
            if (Broker.listViewActivity.touchDown) return convertView;

            IRIssue theIssue = Broker.model.issueFilter.issueShowingList().get(position);
            container = (RelativeLayout) convertView;

            for (int i =0;i<container.getChildCount();i++){

                if (container.getChildAt(i).getClass()== ImageButton.class){
                    final int clickedPosition = position;
                    ((ImageButton)container.getChildAt(i)).setOnClickListener( new OnClickListener(){
                        public void onClick(View arg0) {
                            Broker.listViewActivity.ItemClick(clickedPosition);
                        }});  
                    ((ImageButton)container.getChildAt(i)).setLongClickable(true);
                    ((ImageButton)container.getChildAt(i)).setOnLongClickListener( new OnLongClickListener(){
                        public boolean onLongClick(View arg0) {
                            Broker.listViewActivity.ItemLongClick(clickedPosition);
                            return true;
                        }});  

                    if(theIssue.thumbLocation==null ){
                        ((ImageButton)container.getChildAt(i)).setImageResource(R.raw.default_thumbnail);
                    }else{

                        if(new File(theIssue.thumbLocation).exists()){
                            ((ImageButton)container.getChildAt(i)).setImageURI( Uri.parse(theIssue.thumbLocation)); 
                            if (((ImageButton)container.getChildAt(i)).getDrawable()==null){((ImageButton)container.getChildAt(i)).setImageResource(R.raw.default_thumbnail);}
                        }else
                            ((ImageButton)container.getChildAt(i)).setImageResource(R.raw.default_thumbnail);
                    }

                    // Resize the thumbnail after download complete
                    ImageButton downloadedCover = (ImageButton)container.getChildAt(i);
                    RelativeLayout.LayoutParams imgparam;

                    DisplayMetrics outMetrics = new DisplayMetrics();
                    Broker.listViewActivity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);

                    float expectedHeight = 240 / ((float)downloadedCover.getDrawable().getMinimumWidth()/(float)downloadedCover.getDrawable().getMinimumHeight());
                    int   expectedWidth = 240;

                    if (outMetrics.densityDpi==DisplayMetrics.DENSITY_XHIGH || outMetrics.densityDpi==DisplayMetrics.DENSITY_XXHIGH){
                         expectedWidth = 240;
                         imgparam = new RelativeLayout.LayoutParams(240, (int)expectedHeight);
                    }else{
                        expectedWidth = 200;
                        imgparam = new RelativeLayout.LayoutParams(expectedWidth, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    }

                    imgparam.addRule(RelativeLayout.ALIGN_PARENT_TOP, downloadedCover.getId());
                    imgparam.addRule(RelativeLayout.CENTER_HORIZONTAL, downloadedCover.getId());
                    imgparam.setMargins(10, 20, 10, 0);
                    downloadedCover.setLayoutParams(imgparam);
                    downloadedCover.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    downloadedCover.setAdjustViewBounds(true);

                }else if (container.getChildAt(i).getClass()== TextView.class){
                        ((TextView)container.getChildAt(i)).setText(theIssue.issueNo);
                }else if (container.getChildAt(i).getClass()== AkaProgressBar.class){
                            //((AkaProgressBar)container.getChildAt(i)).setProgress(theIssue.progress); 
                        if (theIssue.vol[0].pageCount != 0)
                            ((AkaProgressBar) container.getChildAt(i)).setProgress(Math.round(((float)theIssue.progress / theIssue.vol[0].pageCount) * 10000));
                        if (theIssue.status==IRConstant.IssueVolumeStatus.Downloading ) 
                            ((AkaProgressBar)container.getChildAt(i)).setVisibility(View.VISIBLE);
                        else 
                            ((AkaProgressBar)container.getChildAt(i)).setVisibility(View.INVISIBLE);
                }else if (container.getChildAt(i).getClass()== ImageView.class){
                        switch (theIssue.status){
                        case NoDownload:
                            ((ImageView)container.getChildAt(i)).setImageResource(R.raw.btn_media_null);
                            break;
                        case Downloading:
                        case DownloadStopped:
                            ((ImageView)container.getChildAt(i)).setImageResource(R.raw.icon_downloading);
                            break;
                        case DownloadedAndExtracted:
                            ((ImageView)container.getChildAt(i)).setImageResource(R.raw.icon_downloaded);
                            break;
                        default:
                            ((ImageView)container.getChildAt(i)).setImageResource(R.raw.btn_media_null);
                        }
                }else if (container.getChildAt(i).getClass()== ProgressBar.class){
                    if (Broker.model.downloadQueue.isItQueued(theIssue.pubKey))
                        ((ProgressBar)container.getChildAt(i)).setVisibility(View.VISIBLE);
                    else 
                        ((ProgressBar)container.getChildAt(i)).setVisibility(View.INVISIBLE);
                }
            }
        }

        container.setId(position);

        return container;

    }


}