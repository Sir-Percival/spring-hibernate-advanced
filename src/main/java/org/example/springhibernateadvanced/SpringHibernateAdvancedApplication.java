package org.example.springhibernateadvanced;

import org.example.springhibernateadvanced.dao.AppDAO;
import org.example.springhibernateadvanced.entity.Instructor;
import org.example.springhibernateadvanced.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateAdvancedApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringHibernateAdvancedApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO)
    {
        return runner ->
        {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO)
    {
        Instructor instructor = new Instructor("John", "Marshal", "john.marsh@gmail.com");
        InstructorDetail detail = new InstructorDetail("http://www.youtube.com/johnMarshal", "History");

        instructor.setInstructorDetail(detail);

        System.out.println("Saving instructor: " + instructor);
        appDAO.save(instructor);
        System.out.println("Instructor saved!");
    }
}
