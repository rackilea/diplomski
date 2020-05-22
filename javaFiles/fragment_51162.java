package register_file_pkg is
    type register_file_type is array (0 to 31) of integer range 0 to 255;
    signal register_file: register_file_type;
    alias pc is register_file(31);
end;
--------------------------------------------------------------------------------
use work.register_file_pkg.all;

entity alu is
    port (
        clock: in bit;
        zero_flag: out boolean;
        last_pc_flag: out boolean
    );
end;

architecture rtl of alu is
begin
    zero_flag <= (register_file(0) = 0);
    last_pc_flag <= (pc = 255);

    process (clock) begin
        if clock'event and clock = '1' then
            register_file(0) <= pc / 4;
        end if;
    end process;
end;
--------------------------------------------------------------------------------
library ieee;
use ieee.numeric_bit.all;
use work.register_file_pkg.all;

entity cpu is
    port (
        clock: in bit;
        address_bus: out integer;
        zero_flag: out boolean;
        last_pc_flag: out boolean
    );
end;

architecture rtl of cpu is
begin
    address_bus <= pc;

    process (clock) begin
        if clock'event and clock = '1' then
            pc <= pc + 1;
        end if;
    end process;

    cpu_alu: entity work.alu
        port map(
            clock => clock,
            zero_flag => zero_flag,
            last_pc_flag => last_pc_flag
        );
end;