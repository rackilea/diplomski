int decrypt(const char *value, char *output, int *output_size) {
    std::string res = TripleDes::getInstance().decrypt(value);
    std::cout << res.c_str() << "\n";

    if (*output_size < res.size()) {
        *output_size = res.size();
        return 0;
    }

    size_t bytes_written = res.copy(output, *output_size);
    return (int)bytes_written;
}