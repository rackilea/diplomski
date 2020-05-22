import re
s = "Install: C:\\Program Files\\app\nDatabase: postgresql://127.0.0.1:42018/app\nStarted: 2016-12-28 10:40:05.908000\nLines: 1000000\nVersion: 4.1\nPID: 1736";
pattern = r"postgresql://[\d.]+:(\d+)\b"
m = re.search(pattern, s)
if m:
    print(m.group(1))