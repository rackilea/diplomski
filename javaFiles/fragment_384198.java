protected void openImpl()
    {
            ...
            m_thread = new Thread(this);
            ...
            m_thread.start();
    }