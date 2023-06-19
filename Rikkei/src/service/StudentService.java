package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {
    SubjectService subjectService = new SubjectService();
    ClasssService classsService = new ClasssService();
    private Student[] studentList = new Student[1000];
//    private Student[] studentList = {
//            new Student(1,"nhungJV1","nhungJV1","nhungJV1","27/04/1996","0967585702",subjectService.getSubjectList()[0],classsService.getClassList()[0],true ),
//            new Student(2,"nhungJV2","nhungJV2","nhungJV2","27/04/1996","0967585702",subjectService.getSubjectList()[0],classsService.getClassList()[0],true ),
//            new Student(3,"nhungJV3","nhungJV3","nhungJV3","27/04/1996","0967585702",subjectService.getSubjectList()[0],classsService.getClassList()[0],true ),
//            new Student(4,"nhungJS4","nhungJS4","nhungJS4","27/04/1996","0967585702",subjectService.getSubjectList()[1],classsService.getClassList()[2],true ),
//            new Student(5,"nhungJS5","nhungJS5","nhungJS5","27/04/1996","0967585702",subjectService.getSubjectList()[1],classsService.getClassList()[2],true ),
//            new Student(6,"nhungJS6","nhungJS6","nhungJS6","27/04/1996","0967585702",subjectService.getSubjectList()[1],classsService.getClassList()[2],true ),
//    };
    private int size;

    public Student[] getStudentList() {
        return studentList;
    }

    public int getSize() {
        return size;
    }
    public void displayList(){
        if(size==0){
            System.out.println("Danh sách học viên trống");
        }
        for (Student student:studentList){
            student.display();
        }
    }
    public Student findbyId(int id){
        for (Student student:studentList){
            if(student!=null&&student.getUserId()==id){
                return student;
            }
        }
        return null;
    }
   public void save(Student student){
        if(findbyId(student.getUserId())==null){
            for (int i = 0; i < studentList.length; i++) {
                if(studentList[i]==null){
                    studentList[i] = student;
                    System.out.println("Thêm mới học viên thành công");
                    size++;
                    break;
                }
            }
        } else {
            for (int i = 0; i < studentList.length; i++) {
                if(studentList[i]!=null&&studentList[i].getUserId()== student.getUserId()){
                    studentList[i] = student;
                    System.out.println("Cập nhật thông tin học viên thành công");
                }
            }
        }
   }
   public void delete (int deleteId){
        if(findbyId(deleteId)==null){
            System.err.println("Mã học viên không tồn tại");
        }
       for (int i = 0; i < studentList.length; i++) {
           if (studentList[i] != null&&studentList[i].getUserId()==deleteId) {
               studentList[i] = null;
               size--;
               System.out.println("Xóa học viên thành công");
           }
       }
   }
    public int getNewId(){
        int maxId = 0;
        for (Student student : studentList) {
            if (student != null&&student.getUserId()>maxId) {
                maxId = student.getUserId();
            }
        }
        return maxId + 1;
    }
    public void getRandomStudent(int randomNum) {
        if (randomNum > size) {
            System.err.println("Lớp không có nhiều học viên thế đâu 😁 ");
        }
        List<Student> selectedStudents = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < randomNum; i++) {
            int index = random.nextInt(size);
            while (studentList[index] == null) {
                index = random.nextInt(size);
            }

            Student student = studentList[index];
            selectedStudents.add(student);
            studentList[index] = null;
        }
        for (Student student : selectedStudents) {
            student.display();
        }
    }

   }
