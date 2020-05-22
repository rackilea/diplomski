m_threadLatch = new CountDownLatch(m_story.photos_thumb.length);
for(int i=0; i<m_story.photos_thumb.length; i++)
    {
    new HTTPGetImages(((MyApplication)getApplication()).getBaseURL() + m_story.photos_thumb[i]).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
new AddImagesToUI().execute();