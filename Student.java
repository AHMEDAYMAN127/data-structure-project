package javaapplication7;
class Studentnode {
    int data;
    Studentnode next;
    courselink enrolledcourses;
//Node constructor 
    public Studentnode (int data){
        this.data=data;
        this.next=null;
        this.enrolledcourses=null;
    }
}

public class Student {
    Studentnode head;  
//add course with ID
public void addstudent(int studentid ){
    Studentnode n1= new Studentnode(studentid);
    if (head==null){
        head=n1;
    }else{
        Studentnode follow =head;
        while (follow.next!=null){
          follow= follow.next;
    }
    follow.next = n1;
}
}
//remove course by ID
public void removestudent (int studentid){
         if (head==null){
             System.out.println("no student added");
             return;
         }
         if (head.data==studentid){
             head=head.next;
             System.out.println("Student has been successfully deleted");
             return;
         }
         Studentnode follow =head;
         while (follow.next!=null){
             if (follow.next.data==studentid){
                 follow.next=follow.next.next;
                 System.out.println("Student has been successfully deleted");
                 return;
             }
             follow=follow.next;
         }
         System.out.println("invalid id");
     }
public void getlaststudentadd(){
         Studentnode follow =head;
         if (head==null){
             System.out.println("no student added");
             return;
         }
         while (follow.next!=null){
             follow=follow.next;
         }
         System.out.println("laststudentadded: "+follow.data);
     }
public boolean cheakstudents(int studentid){
Studentnode follow;
follow=head;
if(head==null){
return false;}
while(follow!=null)
{
if(follow.data==studentid)
{     
return true;
}
follow=follow.next;
}
return false;
}








}
