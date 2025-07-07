package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    /*
    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "John", "Doe");
        return student;
    }
     */

    // http://localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity <Student> getStudent() {
        Student student = new Student(1, "John", "Doe");
        // return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "john").body(student);
    }

    /*
    // http://localhost:8080/students
    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Adam", "Smith"));
        students.add(new Student(3, "Robin", "Sharma"));
        students.add(new Student(4, "Kabir", "Shikhawat"));
        return students;
    }
    */

    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity <List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Adam", "Smith"));
        students.add(new Student(3, "Robin", "Sharma"));
        students.add(new Student(4, "Kabir", "Shikhawat"));
        return ResponseEntity.ok(students);
    }

    /*
    // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/john/doe
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
     */

    // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/john/doe
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity <Student> studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        Student student =  new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /*
    // Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=John&lastName=Doe
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
     */

    // Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=John&lastName=Doe
    @GetMapping("query")
    public ResponseEntity <Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /*
    // Spring Boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
     */

    // Spring Boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /*
    // Spring Boot REST API that handles HTTP PUT Request - updating the existing resource
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
     */

    // Spring Boot REST API that handles HTTP PUT Request - updating the existing resource
    @PutMapping("{id}/update")
    public ResponseEntity <Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    /*
    // Spring Boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully!";
    }
     */

    // Spring Boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity <String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
