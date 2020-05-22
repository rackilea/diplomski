public void saveAB(A a, B b)
{
    saveA(a);
    saveB(b);
}

@Transactional
public void saveA(A a)
{
    dao.saveA(a);
}

@Transactional
public void saveB(B b)
{
    dao.saveB(b);
}