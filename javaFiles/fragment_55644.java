private RefreshThread mRefreshThread = new RefreshThread();

    private Handler mRefreshHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            if (msg.what >= 1) {


                if (isVisible() && mVisible) {
                    createList();
                    mVisible = true;
                } else {
                    // Do nothing
                }

            }
        }
    };

public void createList() {

    // Default Overview Menu
    adapterInit overview_data[] = new adapterInit[]
            {
                    // First Value (0) is for loadable images.
                    new adapterInit(getString(R.string.kernel_version), AeroActivity.shell.getKernel()),
                    new adapterInit(getString(R.string.current_governor), AeroActivity.shell.getInfo(GOV_FILE)),
                    new adapterInit(getString(R.string.current_io_governor), AeroActivity.shell.getInfo(GOV_IO_FILE)),
                    new adapterInit(getString(R.string.current_cpu_speed), getFreqPerCore()),
                    new adapterInit(getString(R.string.current_gpu_speed), AeroActivity.shell.toMHz((AeroActivity.shell.getInfo(gpu_file).substring(0, AeroActivity.shell.getInfo(gpu_file).length() - 3)))),
                    new adapterInit(getString(R.string.available_memory), AeroActivity.shell.getMemory(FILENAME_PROC_MEMINFO))
            };

    listView1 = (ListView) root.findViewById(R.id.listView1);

    adapter = new AeroAdapter(getActivity(),
            R.layout.overviewlist_item, overview_data);

    listView1.setAdapter(adapter);

}