package test;

import java.util.List;

import com.google.gson.Gson;

public class TESTTEST {

    public class MarketInfo {
        String name;
        String address;
        List<Price> prices;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public List<Price> getPrices() {
            return prices;
        }

        public void setPrices(List<Price> prices) {
            this.prices = prices;
        }
    }

    public class Price {
        String nome;
        Double preco;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        @Override
        public String toString() {
            return "{\"nome\":\"" + nome + "\", \"preco\":" + preco + "}";
        }
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonString = "{\"name\": \"Market 01\",\"address\": \"Market 01 street\","
            + "\"prices\": [{\"nome\":\"watermelon\",\"preco\":\"5.40\"}, {\"nome\":\"melon\",\"preco\": \"2.55\"}]}";
        MarketInfo res = gson.fromJson(jsonString, MarketInfo.class);
        System.out.println(res.getPrices());
    }
}