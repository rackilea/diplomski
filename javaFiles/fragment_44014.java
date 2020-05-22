int iTempData = first.iData;
            double dTempData = first.dData;

            first.iData = first.next.iData;
            first.dData = first.next.dData;

            first.next.iData = iTempData;
            first.next.dData = dTempData;