package com.employmeeSystem.dao;

import com.employmeeSystem.entity.Employee;

import jakarta.persistence.*;

import java.util.List;

public class EmployeeDAPImpl implements EmployeeDAO {

    private EntityManagerFactory entityManagerFactory;

    public EmployeeDAPImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("employee-persistence-unit");
    }

    @Override
    public void save(Employee theEmployee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(theEmployee);
        transaction.commit();
    }

    @Override
    public Employee findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List< Employee > findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public List< Employee > findByDepartment(String theDepartment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "FROM Employee WHERE department=:theData", Employee.class);
        theQuery.setParameter("theData", theDepartment);
        return theQuery.getResultList();
    }

    @Override
    public List< Employee > findByPosition(String thePosition) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "FROM Employee WHERE position=:theData", Employee.class);
        theQuery.setParameter("theData", thePosition);
        return theQuery.getResultList();
    }

    @Override
    public List< Employee > findByFirstName(String theFirstName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "FROM Employee WHERE firstName=:theData", Employee.class);
        theQuery.setParameter("theData", theFirstName);
        return theQuery.getResultList();
    }

    @Override
    public void update(Employee theEmployee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(theEmployee);
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Employee theEmployee = entityManager.find(Employee.class, id);
        transaction.begin();
        entityManager.remove(theEmployee);
        transaction.commit();
    }

    @Override
    public int deleteAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Employee").executeUpdate();
        transaction.commit();
        return numRowsDeleted;
    }
}
