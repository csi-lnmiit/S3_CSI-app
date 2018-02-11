package com.example.android.csilnmiit.Model;

/**
 * Created by NIMISH GUPTA on 11-Feb-18.
 */

public class Member {
    private String name;
    private String post;
    private String imgUrl;

    public Member(String name, String post, String imgUrl) {
        this.name = name;
        this.post = post;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
