class File implements Comparable<File>
    {
        public String name;
        public int size;

        File(String passedName, int passedSize)
        {
            this.name = passedName;
            this.size = passedSize;
        }

        @Override
        public int compareTo(File o) {
            //e.g Provide comparable on size
            return Integer.valueOf(size).compareTo(o.size);
        }
    }