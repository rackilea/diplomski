import java.util.List;

class TestBus {
        private String index;
        private String tb_name;
        private List<String> bitf_names;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getTb_name() {
            return tb_name;
        }

        public void setTb_name(String tb_name) {
            this.tb_name = tb_name;
        }

        public List<String> getBitf_names() {
            return bitf_names;
        }

        public void setBitf_names(List<String> bitf_name) {
            this.bitf_names = bitf_name;
        }

        @Override
        public String toString() {
            return "TestBus [index=" + index + ", tb_name=" + tb_name + ", bitf_name=" + bitf_names + "]";
        }
    }