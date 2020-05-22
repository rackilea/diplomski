uint16_t schemaId;
uint64_t lastModifiedDate;
uint32_t binaryLength;

myfile.read(reinterpret_cast<char*>(&schemaId), sizeof(schemaId));
myfile.read(reinterpret_cast<char*>(&lastModifiedDate), sizeof(lastModifiedDate));
myfile.read(reinterpret_cast<char*>(&binaryLength), sizeof(binaryLength));