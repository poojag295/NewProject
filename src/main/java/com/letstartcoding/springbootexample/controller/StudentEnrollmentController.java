package com.letstartcoding.springbootexample.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.letstartcoding.springbootexample.model.Student;
import com.letstartcoding.springbootexample.service.StudentService;

@Controller
public class StudentEnrollmentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/enroll";
    }

    @RequestMapping(value = "/enroll", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "enroll";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student,
                                   BindingResult result,
                                   ModelMap model,
                                   RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "enroll";
        }

        studentService.save(student);
        return "redirect:/viewstudents/1";
    }

    @RequestMapping("/viewstudents")
    public ModelAndView viewstudents() {
        List<Student> list = studentService.getAllStudents();
        return new ModelAndView("viewstudents", "list", list);
    }

    @RequestMapping(value = "/viewstudents/{pageid}")
    public ModelAndView viewByPage(@PathVariable int pageid) {
        int total = 2;

        if (pageid != 1) {
            pageid = (pageid - 1) * total + 1;
        }

        List<Student> list = studentService.getStudentsByPage(pageid, total);
        return new ModelAndView("viewstudents", "list", list);
    }

    @RequestMapping(value = "/editstudent/{id}")
    public String edit(@PathVariable int id, ModelMap model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editstudent";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return new ModelAndView("redirect:/viewstudents/1");
    }

    @RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        studentService.delete(id);
        return new ModelAndView("redirect:/viewstudents/1");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete() {
        studentService.delete();
        return new ModelAndView("redirect:/enroll");
    }

    @ModelAttribute("sections")
    public List<String> initializeSections() {
        List<String> sections = new ArrayList<>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }

    @ModelAttribute("countries")
    public List<String> initializeCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("INDIA");
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }

    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathematics");
        return subjects;
    }

    @ModelAttribute("pageCount")
    public List<String> initializePageCount() {
        int total = 2;
        List<String> pageCount = new ArrayList<>();
        int count = studentService.count();
        int pages = (count + total - 1) / total;

        for (int k = 1; k <= pages; k++) {
            pageCount.add(String.valueOf(k));
        }

        return pageCount;
    }
}
