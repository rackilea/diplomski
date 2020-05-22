char* decrypt(char* value) {
    std::string res = TripleDes::getInstance().decrypt(value);
    std::cout << res.c_str() << "\n";
    return strndup(res.c_str(), res.size());
}

void free_decrypted_string(char* str) {
    free(str);
}