@Test
    void testEqualsObject() {
        Printers a = new Bw("BW_LASER HP", "Laserjet 1230", "25", "180 euros");
        Printers b = new Bw("BW_LASER HP", "Laserjet 1230", "25", "180 euros");
        assertEquals(a,b);
    }