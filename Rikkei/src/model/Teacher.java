package model;

import config.InputMethods;

public class Teacher extends User {
    private Classs classs;
    private boolean status;

    public Teacher() {
    }

    public Teacher(int userId, String username, String password, String fullname, String birthday, String tel, Classs classs, boolean status) {
        super(userId, username, password, fullname, birthday, tel);
        this.classs = classs;
        this.status = status;
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

    public void inputTeacher(Classs[] classList, Subject[] subjectList) {
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
                if (classs != null && classs.getClassName().equals(myClass) && classs.isStatus()) {
                    if (!classs.isStatus()) {
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
            System.out.println("Trạng thái: ");
            this.status = InputMethods.getBoolean(); // set true = vào học
        }
    }
    public void display () {
        System.out.println(super.toString());
        System.out.println("Lớp: " + classs.getClassName() + "\n" +
                "Trạng thái: " + (status ? "Đã xếp lớp" : "Đang đợi lớp"));
    }
}
