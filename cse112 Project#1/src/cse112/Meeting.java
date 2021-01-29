/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse112;

import java.util.ArrayList;
import java.util.Date;
public class Meeting {
    private Date date;
    private ArrayList<Person> attendees;
    private final Person host;
    private String name ;

    public Meeting(String name, Date Date, ArrayList<Person> attendees, Person host) {
        this.date = Date;
        this.attendees = attendees;
        this.host = host;
        this.name = name;
        
    }
    public boolean equals(Meeting a){
        boolean checkPoint ;
        if(a.getHost().equals(this.getHost()) && a.getDate().equals(this.getDate())){
            checkPoint = true;
        }
        else
            checkPoint=false;
        return checkPoint;
    }
    
    
    public void addAttendee(Person person){          
        if(person.addMeeting(this)){
           attendees.add(person);
       }
       else
            System.out.println("Already Joined.");
    }
    
    
    public boolean removeAttendee(Person c){
        boolean checkPoint = false;
        int index =-5;
        for(int i =0;i<this.attendees.size();i++){
            if(this.attendees.get(i).equals(c)){
                index =i;
                checkPoint=true;
                break;                
            }
            if(checkPoint){
                this.attendees.remove(index);
                
            }
        }
        return !checkPoint;
    }
    public void removeAllAttendees(){
        for(int i =0;i<attendees.size();i++){
            attendees.remove(i);
            
        }
    }

    
    @Override
    public String toString() {
        String output ="Meeting Name: " +name +" \nHost info : " + host.toString()+ " \nDate: " + date.toString()+ "\nAttendees List: " + attendees.toString();
        return output;
        
    }
    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }

    public ArrayList<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<Person> attendees) {
        this.attendees = attendees;
    }

    public Person getHost() {
        return host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
