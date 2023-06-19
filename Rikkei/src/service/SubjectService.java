package service;

import model.Subject;

import java.util.Arrays;

public class SubjectService {
    private Subject[] subjectList = {
            new Subject("FTJV", "FT_Java"),
            new Subject("FTJS", "FT_JavaScript"),
            new Subject("PTJV", "PT_Java"),
            new Subject("PTJS", "PT_JavaScript"),
    };
    private int size;

    public Subject[] getSubjectList() {
        return subjectList;
    }

    public int getSize() {
        return size;
    }


}
