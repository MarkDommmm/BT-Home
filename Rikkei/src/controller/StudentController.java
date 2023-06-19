package controller;

import model.Student;
import service.StudentService;

public class StudentController {
    private StudentService studentService = new StudentService();
    public Student[] getStudentList(){
        return studentService.getStudentList();
    }
    public  int getSize() {
        return studentService.getSize();
    }
    public void save(Student student){
        studentService.save(student);
    }
    public void delete(int deleteId){
        studentService.delete(deleteId);
    }
    public Student findById(int id){
        return studentService.findbyId(id);
    }
    public int getNewId(){
        return studentService.getNewId();
    }
    public void getRandomStudent(int randomNum){
        studentService.getRandomStudent(randomNum);
    }
}
