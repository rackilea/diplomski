wget "https://api.coinmarketcap.com/v1/ticker/?limit=9" -O output

cat output | grep 'price_usd' | sed 's/"//g' | sed 's/,//g' | sed 's/price_usd//g' | sed 's/: //g' | awk '{print $1}' >
final.txt

cat final.txt