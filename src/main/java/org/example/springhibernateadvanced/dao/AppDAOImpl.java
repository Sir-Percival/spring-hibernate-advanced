package org.example.springhibernateadvanced.dao;

import jakarta.persistence.EntityManager;
import org.example.springhibernateadvanced.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO
{
    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor)
    {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id)
    {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id)
    {
        Instructor instructor = findInstructorById(id);
        if(instructor != null)
        {
            entityManager.remove(instructor);
        }
    }
}
