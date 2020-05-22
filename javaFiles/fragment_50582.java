public class Main {
    public Main()  {
        Entity entity = new Entity();
        AbstractGameObject aEntity = new AbstractGameObject();

        try {
            BeanUtils.copyProperties(aEntity, entity);
        } catch (Exception ex) {
            // use a logger
        }
        System.out.println(aEntity.similar);
        System.out.println(entity.similar);
    }

    public static void main(String[] args){
        Main main = new Main();
    }

    public class Entity {

        private int similar = 10;
        private int differentE = 9;

        public int getSimilar() {
            return similar;
        }

        public void setSimilar(int similar) {
            this.similar = similar;
        }

        public int getDifferentE() {
            return differentE;
        }

        public void setDifferentE(int differentE) {
            this.differentE = differentE;
        }        

    }

    public  class AbstractGameObject {

        private int similar = 2;
        private int differentA = 1;

        public int getSimilar() {
            return similar;
        }

        public void setSimilar(int similar) {
            this.similar = similar;
        }

        public int getDifferentA() {
            return differentA;
        }

        public void setDifferentA(int differentA) {
            this.differentA = differentA;
        }

    }
}