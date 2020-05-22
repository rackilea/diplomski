# Precompile some regex
looks_like_product_number = re.compile(r'\A[-0-9]+\Z')
not_wordlike = re.compile(r'[^a-zA-Z0-9]')
not_wordlike_or_hyphen = re.compile(r'[^-a-zA-Z0-9]')

# Split on anything that's not a letter, number, or hyphen -- BUT dots
# must be followed by whitespace
words = re.split(r'(?:[^-.a-zA-Z0-9]|[.]\s)+', string)

stripped_words = []
for word in words:
    if '-' in word and not looks_like_product_number.match(word):
        stripped_word = not_wordlike.sub('', word)
    else:
        # Product number; allow dashes
        stripped_word = not_wordlike_or_hyphen.sub('', word)

    stripped_words.append(stripped_word)

pass_to_lucene(' '.join(stripped_words))