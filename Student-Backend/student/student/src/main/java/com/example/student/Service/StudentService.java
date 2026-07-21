package com.example.student.Service;
import com.example.student.exeption.Userfound;
import com.example.student.exeption.Usernotfound;
import com.example.student.model.Student;
import com.example.student.reposetory.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private Studentrepo repo;

    public String addstd(Student std){
        String email= std.getEmail();
        Optional<Student> s=repo.findByEmail(email);
        if(s.isPresent()){

throw new Userfound("user founded in system");

        }
        Student last= repo.findTopByOrderByStidDesc();
        int nextid=1;
        if (last !=null){
            String lastid=last.getStid();
           int num= Integer.parseInt(lastid.substring(5));
             nextid=num+1;
        }
        String newid=String.format("std-%03d",nextid);
        std.setStid(newid);
        repo.save(std);
        return "student added successfully" ;

    }
    public List<Student> getst(){
        List<Student>student=repo.findAll();
        if (student.isEmpty()){
             throw new RuntimeException("data not fouund");
        }
        return student ;
    }
    public Optional<Student> getstbyid(String id){
        Optional<Student> st=repo.findById(id);
        if(st.isEmpty()){
            throw new Usernotfound("user is unavailable");
        }
        return st;
    }
    public String updatest(Student st,String id){

        Optional<Student> sid=repo.findById(id);

        if(sid.isEmpty()){
            throw new Usernotfound("User is unavailable");
        }
        st.setStid(id);
        repo.save(st);
        return "records updated successfully";
    }
    public String deletest(String id){
        Optional<Student> sid=repo.findById(id);
        if(sid.isEmpty()){
            throw new Usernotfound("User is unavailable");
        }else{
            repo.deleteById(id);
        }
        return "user deleted successfully";
    }
}
