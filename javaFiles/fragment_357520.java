// at the class level
@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionPool.class)

// at the beginning your test method
mockStatic(ConnectionPool.class);

final ConnectionPool cp = createMock(ConnectionPool.class);
expect(cp.getConnection()).andReturn(null);
expect(ConnectionPool.getInstance()).andReturn(cp);

replay(ConnectionPool.class, cp);

// the rest of your test