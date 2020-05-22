public static FakeApplication getFakeApplicationInstance() {
            if(fakeApp == null)
                fakeApp = Helpers.fakeApplication(TestUtil.testSettings(), new GlobalCommon());

            return fakeApp;
        }