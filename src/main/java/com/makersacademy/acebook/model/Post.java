package com.makersacademy.acebook.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.sql.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Integer likes;

    @CreationTimestamp
    private Timestamp stamp;


//    @Column
//    private String imagefile;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }
<<<<<<< HEAD

    public Timestamp getStamp() {return this.stamp;}

    public Integer getLikes(){return this.likes;}
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
=======
>>>>>>> 4f1458a (Nav bar edits and start of image upload feature)

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public String getImagefile() {
//        return imagefile;
//    }
//
//    public void setImagefile(String imagefile) {
//        this.imagefile = imagefile;
//    }
}
