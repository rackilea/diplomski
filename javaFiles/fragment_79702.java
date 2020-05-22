} else if ((c > 128)
                   && !Character.isSpaceChar(c)
                   && !Character.isISOControl(c)) {
            // Allow unescaped but visible non-US-ASCII chars
            return p + 1;
        }