// irrelevant code, then
    assertThat(findClass()).isEqualTo(Integer.class);
}

private Class<?> findClass()
{
    return Integer.class;
}