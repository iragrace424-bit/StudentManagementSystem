package com.example.studentmanagement.repository;
import com.example.studentmanagement.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.studentmanagement.model.Student;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
@Repository

public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void saveStudent(Student student) {
        String sql = "INSERT INTO students (full_name, age, email) VALUES (?, ?, ?)";

        String fullName = student.getFirstName() + " " + student.getLastName();

        jdbcTemplate.update(sql, fullName, student.getAge(), student.getEmail());
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));

            String[] names = rs.getString("full_name").split(" ", 2);
            student.setFirstName(names[0]);
            student.setLastName(names.length > 1 ? names[1] : "");

            student.setAge(rs.getInt("age"));
            student.setEmail(rs.getString("email"));

            return student;
        });
    }

}
