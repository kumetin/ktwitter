package com.ktwitter;

import java.util.List;

public interface Twitter {
    void postTweet(int userId, int tweetId);
    List<Integer> getNewsFeed(int userId);
    void follow(int followerId, int followeeId);
    void unfollow(int followerId, int followeeId);
}


