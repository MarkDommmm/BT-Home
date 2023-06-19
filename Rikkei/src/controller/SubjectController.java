package controller;

import model.Subject;
import service.SubjectService;

public class SubjectController {
    SubjectService subjectService = new SubjectService();
    public Subject[] getSubjectList(){
        return subjectService.getSubjectList();
    }
    public int getSize(){
        return subjectService.getSize();
    }
}
