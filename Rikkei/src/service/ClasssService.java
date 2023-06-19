package service;

import model.Classs;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClasssService {
    SubjectService subjectService = new SubjectService();
    private Classs[] classList = {
            new Classs(1,"FT-JV230313",subjectService.getSubjectList()[0], true),
            new Classs(2,"FT-JV230615",subjectService.getSubjectList()[0], false),
            new Classs(3,"FT-JS230213",subjectService.getSubjectList()[1], true),
            new Classs(4,"FT-JS230406",subjectService.getSubjectList()[1], false),
            new Classs(5,"PT-JV230215",subjectService.getSubjectList()[2], true),
            new Classs(6,"PT-JV230425",subjectService.getSubjectList()[2], false),
            new Classs(7,"PT-JS230303",subjectService.getSubjectList()[3], true),
            new Classs(8,"PT-JS230306",subjectService.getSubjectList()[3], false),

    };
    private int size;

    public Classs[] getClassList() {
        return classList;
    }

    public int getSize() {
        return size;
    }

}
