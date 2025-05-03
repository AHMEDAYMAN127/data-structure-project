package javaapplication7;
class CourseNode {
    int data;
    CourseNode next;
    studentlink enrolledstudent;
//Node constructor 
    public CourseNode(int data){
        this.data=data;
        this.next=null;
        this.enrolledstudent=null;
    }
    
}
public class Course {
    CourseNode head;
//add course with ID
public void addcourse(int id){
    CourseNode n=new CourseNode(id);
    if(head==null){
        head=n;
    }else{
        CourseNode follow=head;
        while(follow.next!=null){
          follow=follow.next;
    }
     follow.next=n;
 }
 }
 public void removeCourse(int id){    
          if(head==null){
     System.out.println("no Courses added");
     return;
          }
          if(head.data==id){
 head=head.next;
     System.out.println("course has been successfully deleted");
 return;
 }
 CourseNode follow=head;
 while(follow.next!=null)
 {
if(follow.next.data==id)
{
 follow.next=follow.next.next;
 System.out.println("course has been successfully deleted");
 return;   
} 
follow=follow.next;
 }
     System.out.println("invalid ID");
 }   
public void getlastcourseadded(){
if(head==null){
    System.out.println("no Courses added");
    return;
}
    CourseNode follow=head;
while(follow.next!=null)
{
  follow=follow.next;
}
    System.out.println("lastCourseadded: "+follow.data);
}  
public boolean cheakcourses(int courseid){
CourseNode follow;
follow=head;
if(head==null){
return false;}
while(follow!=null)
{
if(follow.data==courseid)
{
return true;
}
follow=follow.next;
}
    
return false;
}
}
