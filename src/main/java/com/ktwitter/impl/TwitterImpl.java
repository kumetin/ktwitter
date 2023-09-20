package com.ktwitter.impl;

import com.ktwitter.Twitter;

import java.util.*;

/**
 * Naive implementation of the twitter mechanism.
 * Not thread safe.
 */
public class TwitterImpl implements Twitter {
    
    final private TwitterConfiguration conf;
    
    record Tweet(int userId, int tweetId){}
    
    final private List<Tweet> tweets = new ArrayList<>();
    final private FollowGraph followGraph = new FollowGraph();
    
    public static Twitter create(TwitterConfiguration conf) {
        return new TwitterImpl(conf);
    }
    
    @Override
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));
    }
    
    @Override
    public List<Integer> getNewsFeed(int userId) {
        final List<Integer> result = new ArrayList<>();
        final Set<Integer> followees = followGraph.getFollowees(userId);
        int i = tweets.size() - 1;
        while (result.size() < conf.maxTweetsInFeed() && i >= 0) {
            if (followees.contains(tweets.get(i).userId))
                result.add(tweets.get(i).tweetId);
            i = i - 1;
        }
        return result;
    }
    
    @Override
    public void follow(int followerId, int followeeId) {
        followGraph.follow(followerId, followeeId);
    }
    
    @Override
    public void unfollow(int followerId, int followeeId) {
        followGraph.unfollow(followerId, followeeId);
    }
    
    private TwitterImpl(TwitterConfiguration conf) {
        this.conf = conf;
    }
}

