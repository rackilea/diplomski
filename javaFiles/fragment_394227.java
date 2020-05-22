String hex = Integer.toHexString(value); // e056

String hex = Integer.toHexString(value).toUpperCase(); // E056

String hex = String.format("0x%04x", value); // 0xe056

String hex = String.format("0x%04X", value); // 0xE056