DataOutputStream out = new DataOutputStream(os);
out.writeInt(buffer.length + 1);
// This writes a single byte
out.write(0);
out.write(buffer);
out.flush();