static void printHardwareAddresses() throws SocketException {
    if (System.getProperty("os.name").equals("Linux")) {

        // Read all available device names
        List<String> devices = new ArrayList<>();
        Pattern pattern = Pattern.compile("^ *(.*):");
        try (FileReader reader = new FileReader("/proc/net/dev")) {
            BufferedReader in = new BufferedReader(reader);
            String line = null;
            while( (line = in.readLine()) != null) {
                Matcher m = pattern.matcher(line);
                if (m.find()) {
                    devices.add(m.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read the hardware address for each device
        for (String device : devices) {
            try (FileReader reader = new FileReader("/sys/class/net/" + device + "/address")) {
                BufferedReader in = new BufferedReader(reader);
                String addr = in.readLine();

                System.out.println(String.format("%5s: %s", device, addr));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } else {
        // use standard API for Windows & Others (need to test on each platform, though!!)
        ...
    }
}