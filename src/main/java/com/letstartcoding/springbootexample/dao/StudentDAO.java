package com.letstartcoding.springbootexample.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.letstartcoding.springbootexample.model.Student;

@Repository
public class StudentDAO {

    private final Map<Integer, Student> students = new LinkedHashMap<>();
    private int nextId = 1;

    public void save(Student student) {
        student.setId(nextId++);
        students.put(student.getId(), student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public List<Student> getStudentsByPage(int pageid, int total) {
        List<Student> all = getAllStudents();
        int fromIndex = Math.max(0, pageid - 1);
        int toIndex = Math.min(fromIndex + total, all.size());

        if (fromIndex >= all.size()) {
            return new ArrayList<>();
        }

        return all.subList(fromIndex, toIndex);
    }

    public int count() {
        return students.size();
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void update(Student student) {
        students.put(student.getId(), student);
    }

    public void delete(int id) {
        students.remove(id);
    }

    public void delete() {
        students.clear();
    }
}
