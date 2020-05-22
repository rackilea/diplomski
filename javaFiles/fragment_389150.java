public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {

    aDTOList = ListUtils.lazyList(new java.util.ArrayList(), new Factory() {
        public Object create() {
            return buildADTOList();
        }
    });
 }

private ADTO buildADTOList() {
    ADTO aDTO = new ADTO();
    List bDTOList = ListUtils.lazyList(new java.util.ArrayList(), new Factory() {
        public Object create() {
            return new BDTO();
        }
    });
    aDTO.setBDTOList(bDTOList);
    return aDTO;
}