package com.farooq.vid_miner.model;

import lombok.Data;

import java.util.List;

@Data
public class VideoResponse {
    private List<Item> items;

    @Data
    public static class Item {
        private String id;
        private Snippet snippet;
        private Statistics statistics;
    }

    @Data
    public static class Snippet {
        private String publishedAt;
        private String channelId;
        private String title;
        private String description;
        private Thumbnails thumbnails;
        private String channelTitle;
        private String categoryId;
        private String liveBroadcastContent;
    }

    @Data
    public static class Thumbnails {
        private Thumbnail defaultThumbnail;
        private Thumbnail medium;
        private Thumbnail high;
        private Thumbnail standard;
        private Thumbnail maxres;
    }

    @Data
    public static class Thumbnail {
        private String url;
        private int width;
        private int height;
    }

    @Data
    public static class Statistics {
        private String viewCount;
        private String likeCount;
        private String favoriteCount;
        private String commentCount;
    }
}
