package kz.tezdet.lessons.hibernate.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meeting", catalog = "hibernate_db2")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private Long meetingId ;
    @Column(name = "subject")
    private String subject ;

    @Column(name = "meeting_date")
    private Date meetingDate ;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<Employee>() ;

    public Meeting(){

    }

    public Meeting(String subject, Date meetingDate) {
        this.subject = subject;
        this.meetingDate = meetingDate;
    }

    public Meeting(String subject) {
        this.subject = subject;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
