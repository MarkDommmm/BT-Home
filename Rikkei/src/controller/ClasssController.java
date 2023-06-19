package controller;

import model.Classs;
import service.ClasssService;

public class ClasssController {
    ClasssService classsService = new ClasssService();
    public Classs[] getClassList(){
        return classsService.getClassList();
    }
    public int getSize(){
        return classsService.getSize();
    }
}
