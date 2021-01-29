package cse112;

import java.util.ArrayList;

public class Person {

    private String name;
    private int id;
    private static int count;
    private ArrayList<Meeting> myMeetings;
    private ArrayList<Meeting> iOrganize;

    public Person(String name) {
        this.name = name;
        id = count++;                     //BECAUSE ID İS UNIQUE
        iOrganize = new ArrayList<>();
        myMeetings = new ArrayList<>();
    }

    public boolean equals(Person person) {
        if (person.id == this.id) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addMeeting(Meeting meet) {   //Checks the dates than adds to persons meet list
        for (int i = 0; i < myMeetings.size(); i++) {
            if (myMeetings.get(i).getDate() == meet.getDate()) {
                return false;
            }
        }
        myMeetings.add(meet);
        return true;
    }

    public void removeMeeting(Meeting meet) {
        for (int i = 0; i < myMeetings.size(); i++) {
            if (myMeetings.get(i).equals(meet)) {
                myMeetings.remove(i);
                break;
            }
        }

        System.out.println("Not in the list");

    }

    public void organizeMeeting(Meeting meet) {
        iOrganize.add(meet);
    }

    public void cancelMeeting(Meeting meet) {
        if (meet.getHost().equals(this)) {
            for (int i = 0; i < meet.getAttendees().size(); i++) {
                for (int j = 0; j < meet.getAttendees().get(i).myMeetings.size(); j++) {
                    if (meet.equals(meet.getAttendees().get(i).myMeetings.get(j))) {
                        meet.getAttendees().get(i).myMeetings.remove(j);
                        break;
                    }
                }
            }
            meet.removeAllAttendees();
            iOrganize.remove(meet);
        } else {
            System.out.println("Wrong Host");
        }
    }

    public void displayMyMeeting() {
        for (Meeting myMeeting : myMeetings) {
            System.out.println(myMeeting.toString());
        }
    }

    public void displayMyOrganizations() {
        for (Meeting iOrganize1 : iOrganize) {
            System.out.println(iOrganize1.toString());
        }
    }

    @Override
    public String toString() {
        String output = "ıd--> " + id + " name -->" + name;
        return output;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Meeting> getMyMeetings() {
        return myMeetings;
    }

    public void setMyMeetings(ArrayList<Meeting> myMeetings) {
        this.myMeetings = myMeetings;
    }

    public ArrayList<Meeting> getiOrganize() {
        return iOrganize;
    }

    public void setiOrganize(ArrayList<Meeting> iOrganize) {
        this.iOrganize = iOrganize;
    }

    public int getId() {
        return id;
    }

}
