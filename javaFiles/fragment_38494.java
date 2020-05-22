String requestStr = "";
        while (!requestStr.equals(KeyExchangeProtcolMsgs.reqStr)) {
            ch = in.read();
            requestStr = requestStr + (char) ch;
        }

        System.out.println("[I] SSL server received " + requestStr);

        String nonceStr = "";
        while (!requestStr.endsWith(KeyExchangeProtcolMsgs.nonceStr)) {
            ch = in.read();
            nonceStr = nonceStr + (char) ch;
        }

        // Whack #NONCE_END from the end to get just the nonce.

        nonceStr = nonceStr.substring(0, nonceStr.length() - KeyExchangeProtcolMsgs.nonceStr.length());

        System.out.println("[I] SSL server received " + nonceStr);