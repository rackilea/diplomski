for(int z=0;z<scm_details_row.getRowCount();z++){
    ScmTelephoneDetailsViewRowImpl telephone_accounting_details_9 =
        (ScmTelephoneDetailsViewRowImpl)scm_details_row.getRowAtRangeIndex(z);
    ScmTelephoneDetailsViewRowImpl copyRow =
        new ScmTelephoneDetailsViewRowImpl(telephone_accounting_details_9);
    copy_set.add(copyRow);
}