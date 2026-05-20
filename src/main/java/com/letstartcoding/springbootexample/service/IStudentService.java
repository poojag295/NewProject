package com.letstartcoding.springbootexample.service;

import java.util.List;

import com.letstartcoding.springbootexample.model.Student;

public interface IStudentService {

    void save(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentsByPage(int pageid, int total);

    int count();

    Student getStudentById(int id);

    void update(Student student);

    void delete(int id);

    void delete();
}
