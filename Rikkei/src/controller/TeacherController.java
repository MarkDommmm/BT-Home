package controller;
import model.Student;
import model.Teacher;
import service.TeacherService;
public class TeacherController {
    private TeacherService teacherService = new TeacherService();
    public Teacher[] getTeacherList(){
        return teacherService.getTeacherList();
    }
    public  int getSize() {
        return teacherService.getSize();
    }
    public void save(Teacher teacher){
        teacherService.save(teacher);
    }
    public void delete(int deleteId){
        teacherService.delete(deleteId);
    }
    public Teacher findById(int id){
        return teacherService.findbyId(id);
    }
    public int getNewId(){
        return teacherService.getNewId();
    }
}
