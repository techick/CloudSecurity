/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Sijin
 */
public class ModelDAO extends DBManager{

    public ModelDAO() {
        super();

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Model input) {

        boolean isCreate = false;

        try {
            em = getEntityManager();
            Model container = input;
            EntityTransaction et = em.getTransaction();
            et.begin();

            em.persist(container);

            em.flush();
            em.clear();
            et.commit();
            isCreate = true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return isCreate;
        }

    }
}
