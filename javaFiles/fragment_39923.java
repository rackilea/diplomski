@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hardwareName = view.findViewById(R.id.hardware_name);
        hardwareStatus = view.findViewById(R.id.hardware_status);

        softwareName = view.findViewById(R.id.software_name);
        softwareStatus = view.findViewById(R.id.software_status);

        flagName = view.findViewById(R.id.flagreport_name);
    }