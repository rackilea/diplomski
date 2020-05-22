public class DeviceDemo {
    public static void main(String[] args) throws Exception {
        // Initialize
        // On unix this will result in the equivalent of $HOME/.powercontrol/storage/device.xml
        Path file = Paths.get(System.getProperty("user.home"), ".powercontrol", "storage", "device.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Device.class);

        // Read
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputStream = new FileInputStream(file.toFile);
        Device device = (Device) unmarshaller.unmarshal(inputStream);
        inputStream.close();

        // Update
        device.setName("Updated name");
        device.setHost("Updated host");
        device.setPort(2302);

        // Write
        Marshaller marshaller = jaxbContext.createMarshaller();
        OutputStream outputStream = new FileOutputStream(file.toFile);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(device, outputStream);
        outputStream.close();
    }
}