package com.creativityskills.bean;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Local
@Stateless
public class Bean<T> implements BeanI<T> {

    @PersistenceContext(unitName = "pu")
    protected EntityManager entityManager;
    protected Class<T> entityClass;

    @Override
    public T create(T t) {
       entityManager.persist(t);
       return t;
    }

    @Override
    public T read(long id) {
        return entityManager.find(entityClass,id);

    }

    @Override
    public T update(T t) {
        try {
            entityManager.merge(t);
            return t;
        }catch (PersistenceException e){
            return null;
        }

    }

    @Override
    public boolean delete(T t) {
        try {
            entityManager.remove(t);
            return true;
        }catch (PersistenceException e){
            return false;
        }
    }

}
