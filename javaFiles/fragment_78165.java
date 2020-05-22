package com.byteslounge.spring.tx.dialect;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.sessions.UnitOfWork;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;

public class CustomEclipseLinkJpaDialect extends EclipseLinkJpaDialect {

    private static final long serialVersionUID = 1L;

    private boolean lazyDatabaseTransaction = false;

    @Override
    public void setLazyDatabaseTransaction(boolean lazyDatabaseTransaction) {
        this.lazyDatabaseTransaction = lazyDatabaseTransaction;
    }

    @Override
    public Object beginTransaction(final EntityManager entityManager,
            final TransactionDefinition definition)
            throws PersistenceException, SQLException, TransactionException {

        UnitOfWork uow = (UnitOfWork) getSession(entityManager);
        uow.getLogin().setTransactionIsolation(definition.getIsolationLevel());

        entityManager.getTransaction().begin();
        if (!definition.isReadOnly() && !lazyDatabaseTransaction) {
            uow.beginEarlyTransaction();
        }

        return null;
    }
}