package model;

public class Classs {
    private int classId;
    private String className;
    private Subject subject;
    private boolean status;

    public Classs() {
    }

    public Classs(int classId, String className, Subject subject, boolean status) {
        this.classId = classId;
        this.className = className;
        this.subject = subject;
        this.status = status;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "Tên lớp: " + className +
                " | Khóa học: " + subject +
                " | Trạng thái: " + (status?"Lớp vắng quá thêm vào ngay :(":"Lớp đông lắm cần đuổi bớt :))")
                ;
    }
}
