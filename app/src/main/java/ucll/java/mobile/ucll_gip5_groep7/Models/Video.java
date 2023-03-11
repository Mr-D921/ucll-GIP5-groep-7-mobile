package ucll.java.mobile.ucll_gip5_groep7.Models;

import java.time.LocalDateTime;
import java.util.List;

public class Video {
    private String name;
    private int views;
    private int playTime;
    private LocalDateTime uploadDate;
    private List<String> tags;
    private byte data;

    public Video(String name, int views, int playTime, LocalDateTime uploadDate, List<String> tags, byte data) {
        this.name = name;
        this.views = views;
        this.playTime = playTime;
        this.uploadDate = uploadDate;
        this.tags = tags;
        this.data = data;
    }

    public Video(String name, int views, int playTime, LocalDateTime uploadDate) {
        this.name = name;
        this.views = views;
        this.playTime = playTime;
        this.uploadDate = uploadDate;
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

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }
}
