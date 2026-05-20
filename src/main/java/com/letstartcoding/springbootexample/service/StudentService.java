package com.letstartcoding.springbootexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letstartcoding.springbootexample.dao.StudentDAO;
import com.letstartcoding.springbootexample.model.Student;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentDAO studentDao;

    public void save(Student student) {
        studentDao.save(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public List<Student> getStudentsByPage(int pageid, int total) {
        return studentDao.getStudentsByPage(pageid, total);
    }

    public int count() {
        return studentDao.count();
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(int id) {
        studentDao.delete(id);
    }

    public void delete() {
        studentDao.delete();
    }
}
