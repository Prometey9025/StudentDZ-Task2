package com.studentdz.spring.dao;

import com.studentdz.spring.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> index() {
        return jdbcTemplate.query("SELECT * FROM Students", new BeanPropertyRowMapper<>(Student.class));
    }


    public Student show(int id) {
        return jdbcTemplate.query("SELECT * FROM Students WHERE studentid=?", new Object[]{id}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }


    public void save(Student student) {
        jdbcTemplate.update("INSERT INTO students(name, surname, patronymic, birthday, studentgroup) VALUES(?, ?, ?, ?, ?)", student.getName(), student.getSurname(),
                student.getPatronymic(), student.getBirthday(), student.getStudentgroup());
    }


    public void update(int id, Student updateStudent) {
        jdbcTemplate.update("UPDATE students SET name=?, surname=?, patronymic=?,birthday=?,studentgroup=? WHERE studentid=?",updateStudent.getName(), updateStudent.getSurname(),
                updateStudent.getPatronymic(), updateStudent.getBirthday(), updateStudent.getStudentgroup(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Students WHERE studentid=?", id);
    }
}
