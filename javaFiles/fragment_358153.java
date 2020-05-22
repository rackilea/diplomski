XBee xbee(p28, p27);
DigitalOut reset(p11);
DigitalOut mbed_led1(LED1);

int main() {
    Serial terminal(USBTX, USBRX);
    while(!terminal.readable()) {
        wait_ms(10);
    }
    terminal.getc();
    mbed_led1 = 1;
    xbee.begin(9600);
    reset = 0;
    wait_ms(100);
    reset = 1;
    wait_ms(100);

    while(1) {
        terminal.puts("Reading packet...\r\n");
        xbee.readPacket(500);
        XBeeResponse response = xbee.getResponse();
        if (response.isAvailable()) {
            terminal.puts("Packet available\r\n");
            XBeeResponse response = xbee.getResponse();

            char tmp[20];
            sprintf(tmp, "0x%02X", response.getApiId());
            terminal.puts("Response available at API: ");
            terminal.puts(tmp);
            terminal.puts("\r\n");
            uint8_t api = response.getApiId();
            if (api == RX_16_RESPONSE) {
                Rx16Response rx16 = Rx16Response();
                response.getRx16Response(rx16);
                uint8_t len = rx16.getDataLength();
                char l[20];
                sprintf(l, "%d", len);

                terminal.puts("We have data of length ");
                terminal.puts(l);
                terminal.puts("\r\n");
            }
        }

        wait(1);
    }
}