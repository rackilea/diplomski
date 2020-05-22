1. Start with 10000.0;
2. withdraw(11000.0) -> -1000.0
3. Print balance -> "Balance: -1000.0"
4. deposit(11000.0) -> 10000.0
5. withdraw(11001.0); -> -1001.0 < -1000.0
6. Overdrawn (enters else block) -> "Error - Account limit is exceeded"
7. Print balance -> "Balance: 10000.0"