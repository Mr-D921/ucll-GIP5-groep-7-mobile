package ucll.java.mobile.ucll_gip5_groep7_mobile.Models;

import java.time.LocalDateTime;
import java.util.List;

public class Video {

    private int id;
    private String name;
    private int views;

    public Video() {
    }

    public Video(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}

