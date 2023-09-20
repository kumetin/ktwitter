package com.ktwitter.impl;

import com.ktwitter.Twitter;
import com.ktwitter.impl.assertions.ListAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TwitterImplTest {
    
    @Test
    void verifyFeedIsCalculatedInCorrectOrder() {
        final TwitterConfiguration conf = new TwitterConfiguration(10);
        Twitter twitter = TwitterImpl.create(conf);
        twitter.postTweet(1, 5);
        ListAssertions.assertEquals(List.of(5), twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        ListAssertions.assertEquals(List.of(6,5), twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        ListAssertions.assertEquals(List.of(5), twitter.getNewsFeed(1));
    }
}