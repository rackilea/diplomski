if (current.data.equals(data)) {
                found = true;
                if (current.next == null) {
                    current.previous.next = null;
                } else {
                    current.previous.next = current.next;
                }
            }