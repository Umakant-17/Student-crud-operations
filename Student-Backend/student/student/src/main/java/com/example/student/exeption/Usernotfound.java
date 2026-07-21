package com.example.student.exeption;

public class Usernotfound extends RuntimeException{
    public Usernotfound(String msg){
        super(msg);
    }
}
