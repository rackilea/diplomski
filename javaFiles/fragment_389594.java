static class GraphFactory implements Factory<Graph<Integer,String>> {
        public Graph<Integer,String> create() {
            return new SparseMultigraph<Integer,String>();
        }
    }

    static class VertexFactory implements Factory<Integer> {
        int a = 0;
        public Integer create() {
            return a++;
        }

    }
    static class EdgeFactory implements Factory<String> {
        char aa = 'a';
        public String create() {
            return Character.toString(aa++);
        }

    }