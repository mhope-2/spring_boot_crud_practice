package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @Test
    void itShouldFindStudentByEmail() {
        // given
        String email = "heloo@gmail.com";
        Student student = new Student("Name",
                                      email,
                LocalDate.of(2001, 8, 1));
        underTest.save(student);
        // when
        Optional<Student> expected = underTest.findStudentByEmail(email);
        // then
        assertThat(expected).isPresent();
    }
}