{
  "settings": {
    "analysis": {
      "analyzer": {
        "custom_analyzer": {
          "type": "custom",
          "tokenizer": "my_tokenizer",
          "char_filter": [
            "html_strip"
          ],
          "filter": [
            "lowercase",
            "asciifolding"
          ]
        }
      },
      "tokenizer": {
        "my_tokenizer": {
          "type": "ngram",
          "min_gram": 3,
          "max_gram": 3,
          "token_chars": [
            "letter",
            "digit"
          ]
        }
      }
    }
  },
  "mappings": {
    "doc": {
      "properties": {
        "attachment": {
          "properties": {
            "content": {
              "type": "text",
              "analyzer": "custom_analyzer"
            },
            "content_length": {
              "type": "long"
            },
            "content_type": {
              "type": "text"
            },
            "language": {
              "type": "text"
            }
          }
        },
        "resume": {
          "type": "text"
        }
      }
    }
  }
}