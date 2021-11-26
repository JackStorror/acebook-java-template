package com.makersacademy.acebook.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Integer likes;
    private LocalDateTime stamp;

    public Post() {}
    public Post(String content) {
        this.content = content;
    }

    public LocalDateTime getStamp() {return this.stamp;}


    public void setStamp(LocalDateTime my_Time) {
        this.stamp = my_Time;
    }

    public Integer getLikes(){return this.likes;}
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return id != null && Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
