Params: []interface{}{
            from, // first parameter is address to send from (where the ZEC comes from)
            []interface{}{
                map[string]interface{}{
                    "amount":  msgval,
                    "address": to,
                    "memo":    hex.EncodeToString([]byte(msg)),
                },
            },