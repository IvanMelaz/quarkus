package org.telesoccorso.service;

import org.telesoccorso.exception.TscException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class CodaEveServiceImpl implements  CodaEveService{
    @Inject
    EntityManager entityManager;

    @Override
    public String jsonQueueGetAllarms(String user) {
        return null;
    }

    @Override
    public void removeAllarme(String id_allarme) {

    }

    @Override
    public void updateAllarme(String id_allarme, String user) {

    }

    @Override
    public void insertAllarmiInCodaEve(String matricola, String evento, String centrale, String mux, String ritardo) {

    }

    @Transactional
    @Override
    public void insertAllarmiInCodaEve_Brondi(String telefono, String filename, String centrale) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("sp_i_InsertAllarmi_in_CodaEve_Brondi");
            storedProcedureQuery.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);
            storedProcedureQuery.registerStoredProcedureParameter(3,String.class, ParameterMode.IN);
            storedProcedureQuery.setParameter(1,telefono);
            storedProcedureQuery.setParameter(2,"");
            storedProcedureQuery.setParameter(3,centrale);
            storedProcedureQuery.executeUpdate();
        } catch (Exception e) {
            throw new TscException(e);
        }
    }

}
