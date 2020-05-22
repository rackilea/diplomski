boolean flag = false;
for (int i = 0;; i++) {
    thisblock: {
        inputs[i] = B.readLine();
        if (inputs[i].charAt(0) == '0') {
            flag = true;
            break thisblock;
        }
        count++;
    }
    if (flag)
        break;
}