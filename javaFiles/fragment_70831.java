void clean() {
            if (head == -1) return;
            if (full) {
                for (int i = 0; i < capacity; i++) {
                    values[i] = 0f;
                }
            } else {
                for (int i = 0; i <= head; i++) {
                    values[i] = 0f;
                }
            }
            sum = 0;
            average = 0;
            head = -1;
            full = false;
        }