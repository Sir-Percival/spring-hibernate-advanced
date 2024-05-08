package org.example.springhibernateadvanced.dao;

import org.example.springhibernateadvanced.entity.Instructor;

public interface AppDAO
{
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
}
