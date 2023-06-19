package model;

import config.InputMethods;

import java.util.Date;

public class Student extends User {

    private Subject subject;
    private Classs classs;
    private boolean status = false;

    public Student() {
    }

    public Student(int userId, String username, String password, String fullname, String birthday, String tel, Subject subject, Classs classs, boolean status) {
        super(userId, username, password, fullname, birthday, tel);
        this.subject = subject;
        this.classs = classs;
        this.status = status;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputStudent(Classs[] classList, Subject[] subjectList) {
        super.inputData();

        System.out.println("Danh sách lớp học");
        for (Classs classs : classList) {
            if (classs != null) {
                System.out.println(classs);
            }
        }
        System.out.println("Chọn lớp: ");
        while (true) {
            String myClass = InputMethods.getString();
            boolean flag = true;
            for (Classs classs : classList) {
                if (classs != null && classs.getClassName().equals(myClass)&& classs.isStatus()) {
                    if(!classs.isStatus()){
                        System.err.println("Full slot!!!");
                    } else {
                        flag = false;
                        this.classs = classs;
                        break;
                    }
                }
            }
            if (flag) {
                System.err.println("Không tồn tại lớp học này");
            } else {
                break;
            }
//        System.out.println("Khóa học: ");
//        String mySubject = InputMethods.getString();
//        for (Subject subject:subjectList){
//            if(subject!=null&&subject.getSubjectName().equals(mySubject)){
//                this.subject = subject;
//            } else {
//                System.err.println("Không tồn tại khóa học này");
//            }
//        }

        }
        System.out.println("Trạng thái: ");
        this.status = InputMethods.getBoolean(); // set true = vào học
    }
    public void display () {
        System.out.println(super.toString());
        System.out.println(  "Lớp: " + classs.getClassName() + "\n" +
                "Khóa học: " + classs.getSubject() + "\n" +
                "Trạng thái: " + (status ? "Đã xếp lớp" : "Đang đợi lớp"));
    }
}
