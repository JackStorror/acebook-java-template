package com.makersacademy.acebook.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "LIKES")

public class Likes {

    @Id
    private UUID likesID = UUID.randomUUID();
    private Integer likes;
    private UUID postID;

    public Likes(Integer likes) {
        this.likes = likes;
    }

    public Integer getLikes(){return this.likes;}
    public void setLikes(Integer likes){
        Integer finalLikes = likes + 5;

        this.likes = finalLikes;}

}

//
//        const getLike = document.querySelector('.like');
//        const getLikeNum = document.querySelector('.likeNum');
//
//        let like = 0;
//
//
//        increaseLike = () => {
//        like++
//        getLikeNum.innerHTML = `${like}`
//        }
//
//
//        likeClick = () => {
//        increaseLike();
//        }
//
//
//        getLike.addEventListener(('click'), likeClick);
