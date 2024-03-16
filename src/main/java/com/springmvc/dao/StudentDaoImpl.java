package com.springmvc.dao;
import com.springmvc.beans.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
  
import java.util.List;
  
public class StudentDaoImpl implements StudentDao{
	@Autowired
    private HibernateTemplate hTemplate;
  
    public void sethTemplate(HibernateTemplate hTemplate)
    {
    	System.out.println(hTemplate);
        this.hTemplate = hTemplate;
    }
    
    
   
    @Transactional
    public int insert(Student s) 
    {
        return (Integer) hTemplate.save(s);
    }
  
  
    @Transactional
    public void delete(int id)
    {
        Student s=hTemplate.get(Student.class,id);
        hTemplate.delete(s);
    }
  
   
    @Transactional
    public void delete(Student s)
    {
        hTemplate.delete(s);
    }
  
  
    @Transactional
    public void update(Student s) 
    {
        hTemplate.update(s);
    }
  
   
    public Student getStudent(int id) 
    {
        Student student=hTemplate.get(Student.class,id);
        return student;
    }
  
   
    public List<Student> getAllStudents()
    {
        List<Student> list=hTemplate.loadAll(Student.class);
        return list;
    }
    
    
}