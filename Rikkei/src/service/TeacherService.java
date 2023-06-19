package service;

import model.Teacher;

public class TeacherService {
        SubjectService subjectService = new SubjectService();
        ClasssService classsService = new ClasssService();
        private Teacher[] teacherList = new Teacher[100];
        private int size;
//        private Student[] teacherList = new Student[1000];
        //    private Student[] teacherList = {
//            new Student(1,"nhungJV1","nhungJV1","nhungJV1","27/04/1996","0967585702",subjectService.getSubjectList()[0],classsService.getClassList()[0],true ),
//            new Student(2,"nhungJV2","nhungJV2","nhungJV2","27/04/1996","0967585702",subjectService.getSubjectList()[0],classsService.getClassList()[0],true ),
//            new Student(3,"nhungJV3","nhungJV3","nhungJV3","27/04/1996","0967585702",subjectService.getSubjectList()[0],classsService.getClassList()[0],true ),
//            new Student(4,"nhungJS4","nhungJS4","nhungJS4","27/04/1996","0967585702",subjectService.getSubjectList()[1],classsService.getClassList()[2],true ),
//            new Student(5,"nhungJS5","nhungJS5","nhungJS5","27/04/1996","0967585702",subjectService.getSubjectList()[1],classsService.getClassList()[2],true ),
//            new Student(6,"nhungJS6","nhungJS6","nhungJS6","27/04/1996","0967585702",subjectService.getSubjectList()[1],classsService.getClassList()[2],true ),
//    };

        public Teacher[] getTeacherList() {
            return teacherList;
        }

        public int getSize() {
            return size;
        }
        public void displayList(){
            if(size==0){
                System.out.println("Danh sách giảng viên trống");
            }
            for (Teacher teacher:teacherList){
                teacher.display();
            }
        }
        public Teacher findbyId(int id){
            for (Teacher teacher:teacherList){
                if(teacher!=null&&teacher.getUserId()==id){
                    return teacher;
                }
            }
            return null;
        }
        public void save(Teacher teacher){
            if(findbyId(teacher.getUserId())==null){
                for (int i = 0; i < teacherList.length; i++) {
                    if(teacherList[i]==null){
                        teacherList[i] = teacher;
                        System.out.println("Thêm mới giảng viên thành công");
                        size++;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < teacherList.length; i++) {
                    if(teacherList[i]!=null&&teacherList[i].getUserId()== teacher.getUserId()){
                        teacherList[i] = teacher;
                        System.out.println("Cập nhật thông tin giảng viên thành công");
                    }
                }
            }
        }
        public void delete (int deleteId){
            if(findbyId(deleteId)==null){
                System.err.println("Mã giảng viên không tồn tại");
            }
            for (int i = 0; i < teacherList.length; i++) {
                if (teacherList[i] != null&&teacherList[i].getUserId()==deleteId) {
                    teacherList[i] = null;
                    size--;
                    System.out.println("Xóa giảng viên thành công");
                }
            }
        }
        public int getNewId(){
            int maxId = 0;
            for (Teacher teacher : teacherList) {
                if (teacher != null&&teacher.getUserId()>maxId) {
                    maxId = teacher.getUserId();
                }
            }
            return maxId + 1;
        }

    

}
