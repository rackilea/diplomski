package com.github.goto1134.libzbc;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.util.EnumMapper.IntegerEnum;

public class zbc_device_info
        extends Struct {
    public static final int ZBC_DEVICE_INFO_LENGTH = 32;


    public final Enum<zbc_dev_type> zbd_type = new Enum<>(zbc_dev_type.class);
    public final Enum<zbc_dev_model> zbd_model = new Enum<>(zbc_dev_model.class);
    public final UTF8String zbd_vendor_id = new UTF8String(ZBC_DEVICE_INFO_LENGTH);
    public final Unsigned32 zbd_flags = new Unsigned32();
    public final Unsigned64 zbd_sectors = new Unsigned64();
    public final Unsigned32 zbd_lblock_size = new Unsigned32();
    public final Unsigned64 zbd_lblocks = new Unsigned64();
    public final Unsigned32 zbd_pblock_size = new Unsigned32();
    public final Unsigned64 zbd_pblocks = new Unsigned64();
    public final Unsigned64 zbd_max_rw_sectors = new Unsigned64();
    public final Unsigned32 zbd_opt_nr_open_seq_pref = new Unsigned32();
    public final Unsigned32 zbd_opt_nr_non_seq_write_seq_pref = new Unsigned32();
    public final Unsigned32 zbd_max_nr_open_seq_req = new Unsigned32();


    protected zbc_device_info(Runtime runtime) {
        super(runtime);
    }

    public enum zbc_dev_type
            implements IntegerEnum {

        /**
         * Unknown drive type.
         */
        ZBC_DT_UNKNOWN(0x00),

        /**
         * Zoned block device (for kernels supporting ZBC/ZAC).
         */
        ZBC_DT_BLOCK(0x01),

        /**
         * SCSI device.
         */
        ZBC_DT_SCSI(0x02),

        /**
         * ATA device.
         */
        ZBC_DT_ATA(0x03),

        /**
         * Fake device (emulation mode).
         */
        ZBC_DT_FAKE(0x04);

        private final int value;

        zbc_dev_type(int value) {

            this.value = value;
        }

        @Override
        public int intValue() {
            return value;
        }
    }

    public enum zbc_dev_model
            implements IntegerEnum {

        /**
         * Unknown drive model.
         */
        ZBC_DM_DRIVE_UNKNOWN(0x00),

        /**
         * Host-aware drive model: the device type/signature is 0x00
         * and the ZONED field of the block device characteristics VPD
         * page B1h is 01b.
         */
        ZBC_DM_HOST_AWARE(0x01),

        /**
         * Host-managed drive model: the device type/signature is 0x14/0xabcd.
         */
        ZBC_DM_HOST_MANAGED(0x02),

        /**
         * Drive-managed drive model: the device type/signature is 0x00
         * and the ZONED field of the block device characteristics VPD
         * page B1h is 10b.
         */
        ZBC_DM_DEVICE_MANAGED(0x03),

        /**
         * Standard block device: the device type/signature is 0x00
         * and the ZONED field of the block device characteristics VPD
         * page B1h is 00b.
         */
        ZBC_DM_STANDARD(0x04);

        private final int value;

        zbc_dev_model(int value) {

            this.value = value;
        }

        @Override
        public int intValue() {
            return value;
        }
    }
}