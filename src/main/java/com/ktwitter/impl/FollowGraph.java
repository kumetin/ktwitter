package com.ktwitter.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FollowGraph {
    
    // follower --> followees
    private Map<Integer, Set<Integer>> graph = new HashMap<>();
    
    public void follow(int followerId, int followeeId) {
        getFollowees(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        getFollowees(followerId).remove(followeeId);
    }
    
    public Set<Integer> getFollowees(int followerId) {
        if (!graph.containsKey(followerId)) {
            HashSet<Integer> followees = new HashSet<>(Set.of(followerId));
            graph.put(followerId, followees);
        }
        return graph.get(followerId);
    }
}
