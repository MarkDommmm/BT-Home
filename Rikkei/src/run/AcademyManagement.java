package run;

import config.InputMethods;
import controller.ClasssController;
import controller.StudentController;
import controller.SubjectController;
import controller.TeacherController;
import model.Classs;
import model.Student;
import model.Teacher;

public class AcademyManagement {
    private final static StudentController studentController = new StudentController();
    private final static TeacherController teacherController = new TeacherController();
    private final static ClasssController classsController = new ClasssController();
    private final static SubjectController subjectController = new SubjectController();

    public static void main(String[] args) {

        boolean loop = true;
        while (loop) {
            System.out.println("=======Welcome to Rikkei Academy======");
            System.out.println("1. Quản lý học viên");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý lớp học");
            System.out.println("4. Thoát");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    studentManagementMenu();
                    break;
                case 2:
                    teacherManagementMenu();
                    break;
                case 3:
                    classManagementMenu();
                    break;
                case 4:
                    System.out.println("Hẹn gặp lại!!!");
                    loop = false;
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập đúng số lựa chọn");
                    break;
            }
        }
    }

    public static void studentManagementMenu() {
        while (true) {
            System.out.println("======Quản lý học viên======");
            System.out.println("1. Hiển thị danh sách tất cả học viên");
            System.out.println("2. Hiển thị danh sách học viên theo lớp");
            System.out.println("3. Thêm mới học viên"); // thêm số lượng tùy ý
            System.out.println("4. Xem thông tin học viên theo ID");
            System.out.println("5. Tìm kiếm học viên theo tên");
            System.out.println("6. Quay lại");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    displayStudentList();
                    break;
                case 2:
                    displayStudentListByClass();
                    System.out.println("1. Hiển thị ngẫu nhiên số lượng học viên trong lớp");
                    int bonusRandom = InputMethods.getInteger();
                    switch (bonusRandom) {
                        case 1:
                            getRandomStudent();
                            break;
                        default:
                            System.err.println("Vui lòng nhập đúng số lựa chọn");
                    }
                    break;
                case 3:
                    createStudent();
                    break;
                case 4:
                    displayStudentById();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Vui lòng nhập đúng số lựa chọn");
            }
            if (choice == 6) {
                break;
            }
        }
    }


    public static void createStudent() {
        int size = studentController.getSize();
        int maxQuantity = studentController.getStudentList().length - size;
        System.out.println("Nhập số lượng học viên muốn thêm: ");
        int quantity;
        while (true) {
            quantity = InputMethods.getPositiveInteger();
            if (quantity > maxQuantity) {
                System.err.println("Nhập quá số lượng có thể thêm!");
            } else {
                break;
            }
        }
        for (int i = 1; i <= quantity; i++) {
            System.out.println("Nhập thông tin học viên: ");
            Student newStudent = new Student();
            int newId = studentController.getNewId();
            newStudent.setUserId(newId);
            System.out.println("ID: " + newId);
            newStudent.inputStudent(classsController.getClassList(), subjectController.getSubjectList());
            studentController.save(newStudent);
        }
    }

    public static void displayStudentList() {
        if (studentController.getSize() == 0) {
            System.out.println("Danh sách học viên trống");
        }
        for (Student student : studentController.getStudentList()) {
            if (student != null) {
                student.display();
            }
        }
    }

    public static void displayStudentListByClass() {
        System.out.println("Danh sách lớp học: ");
        for (Classs classs : classsController.getClassList()) {
            if (classs != null) {
                System.out.println(classs);
            }
        }
        System.out.println("Nhập lớp học bạn muốn xem danh sách học viên: ");
        String choosenClass = InputMethods.getString();
        for (Classs classs : classsController.getClassList()) {
            if (classs != null && classs.getClassName().equals(choosenClass)) {
                for (Student student : studentController.getStudentList()) {
                    if (student != null && student.getClasss().getClassName().equals(choosenClass)) {
                        student.display();
                    }
                }
            } else {
                System.err.println("Không tồn tại lớp học này");
            }
        }
    }

    public static void getRandomStudent() {
        System.out.print("Số lượng học viên ngẫu nhiên muốn hiển thị ");
        int randomNum = InputMethods.getPositiveInteger();
        studentController.getRandomStudent(randomNum);
    }

    public static void displayStudentById() {
        System.out.println("Nhập ID học viên: ");
        int choosenId = InputMethods.getPositiveInteger();
        if (studentController.getSize() == 0) {
            System.out.println("Danh sách học viên trống!!!");
        }
        for (Student student : studentController.getStudentList()) {
            if (student != null && student.getUserId() == choosenId) {
                student.display();
            }
        }
        System.out.println("1. Sửa thông tin học viên");
        System.out.println("2. Xóa thông tin học viên");
        System.out.println("3. Quay lại");
        int bonusChoice = InputMethods.getInteger();
        switch (bonusChoice) {
            case 1:
                Student editStudent = studentController.findById(choosenId);
                editStudent.inputStudent(classsController.getClassList(), subjectController.getSubjectList());
                studentController.save(editStudent);
                break;
            case 2:
                studentController.delete(choosenId);
                break;
            case 3:
                break;
        }
    }

    public static void searchStudentByName() {
        System.out.println("Nhập từ khóa tìm kiếm học viên:");
        String keyword = InputMethods.getString();
        Student[] result = new Student[1000];
        int i = 0;
        for (Student student : studentController.getStudentList()) {
            if (student != null && student.getFullname().contains(keyword)) {
                result[i] = student;
                i++;
            }
        }
        for (Student student : result) {
            if (student != null) {
                student.display();
            }
        }
    }

    public static void teacherManagementMenu() {
        while (true) {
            System.out.println("======Quản lý giảng viên======");
            System.out.println("1. Hiển thị danh sách tất cả giảng viên");
            System.out.println("2. Hiển thị danh sách giảng viên theo lớp");
            System.out.println("3. Thêm mới giảng viên"); // thêm 1
            System.out.println("4. Xem thông tin giảng viên theo ID");
            System.out.println("4.1. Sửa thông tin giảng viên");
            System.out.println("4.2. Xóa thông tin giảng viên");
            System.out.println("4.3. Quay lại");
            System.out.println("5. Tìm kiếm giảng viên theo tên");
            System.out.println("6. Quay lại");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    displayTeacherList();
                    break;
                case 2:
                    displayTeacherListByClass();
                    break;
                case 3:
                    createTeacher();
                    break;
                case 4:
                    displayTeacherById();
                    break;
                case 5:
                    searchTeacherByName();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Vui lòng nhập đúng số lựa chọn");
            }
            if (choice == 6) {
                break;
            }
        }
    }

    public static void createTeacher() {
        System.out.println("Nhập thông tin giảng viên: ");
        Teacher newTeacher = new Teacher();
        int newId = teacherController.getNewId();
        newTeacher.setUserId(newId);
        System.out.println("ID: " + newId);
        newTeacher.inputTeacher(classsController.getClassList(), subjectController.getSubjectList());
        teacherController.save(newTeacher);

    }

    public static void displayTeacherList() {
        if (teacherController.getSize() == 0) {
            System.out.println("Danh sách giảng viên trống");
        }
        for (Teacher teacher : teacherController.getTeacherList()) {
            if (teacher != null) {
                teacher.display();
            }
        }
    }

    public static void displayTeacherListByClass() {
        System.out.println("Danh sách lớp học: ");
        for (Classs classs : classsController.getClassList()) {
            if (classs != null) {
                System.out.println(classs);
            }
        }
        System.out.println("Nhập lớp học bạn muốn xem danh sách giảng viên: ");
        String choosenClass = InputMethods.getString();
        for (Classs classs : classsController.getClassList()) {
            if (classs != null && classs.getClassName().equals(choosenClass)) {
                for (Teacher teacher : teacherController.getTeacherList()) {
                    if (teacher != null && teacher.getClasss().getClassName().equals(choosenClass)) {
                        teacher.display();
                    }
                }
            } else {
                System.err.println("Không tồn tại lớp học này");
            }
        }
    }

    public static void searchTeacherByName() {
        System.out.println("Nhập từ khóa tìm kiếm giảng viên:");
        String keyword = InputMethods.getString();
        Teacher[] result = new Teacher[1000];
        int i = 0;
        for (Teacher teacher : teacherController.getTeacherList()) {
            if (teacher != null && teacher.getFullname().contains(keyword)) {
                result[i] = teacher;
                i++;
            }
        }
        for (Teacher teacher : result) {
            if (teacher != null) {
                teacher.display();
            }
        }
    }

    public static void displayTeacherById() {
        System.out.println("Nhập ID giảng viên: ");
        int choosenId = InputMethods.getPositiveInteger();
        if (teacherController.getSize() == 0) {
            System.out.println("Danh sách giảng viên trống!!!");
        }
        for (Teacher teacher : teacherController.getTeacherList()) {
            if (teacher != null && teacher.getUserId() == choosenId) {
                teacher.display();
            }
        }
        System.out.println("1. Sửa thông tin giảng viên");
        System.out.println("2. Xóa thông tin giảng viên");
        System.out.println("3. Quay lại");
        int bonusChoice = InputMethods.getInteger();
        switch (bonusChoice) {
            case 1:
                Teacher editTeacher = teacherController.findById(choosenId);
                editTeacher.inputTeacher(classsController.getClassList(), subjectController.getSubjectList());
                teacherController.save(editTeacher);
                break;
            case 2:
                teacherController.delete(choosenId);
                break;
            case 3:
                break;
        }
    }

    public static void classManagementMenu() {
        System.out.println("======Quản lý lớp học======");
        System.out.println("1. Hiển thị danh sách tất cả lớp học"); // id, class, subject
        System.out.println("2. Hiển thị lớp theo khóa học");
        System.out.println("3. Xem thông tin lớp theo ID"); // class, subject, SL teacher, SL student
        System.out.println("3.1. Xem danh sách học viên trong lớp");
        System.out.println("3.2. Xem danh sách giảng viên trong lớp");
        System.out.println("3.3. Quay lại");
        System.out.println("4. Thay đổi trạng thái lớp");
        System.out.println("5. Quay lại");
    }
}
