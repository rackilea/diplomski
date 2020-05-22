@XmlRootElement
class Wrapper {
        /**
         * Everything else
         */
        @Transient
        @XmlAnyElement(lax = true)
        private List<Element> any;


        public List<Element> getAny() {
            return any;
        }

}