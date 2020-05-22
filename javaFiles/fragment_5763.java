1) File Header
DWORD filesize
DWORD checksum
BYTE  endianness;
DWORD entrypoint <-- Entry point for first instruction in main() or whatever
2) String table
DWORD numstrings
<strings>
DWORD stringlen
<string bytes/words>

3) Instructions
DWORD numinstructions
<instructions>
DWORD opcode
DWORD numops <--- or deduce from opcode
DWORD op1_type <--- stack index, integer literal, index to string table, etc
DWORD operand1
DWORD op1_type
DWORD operand2
...