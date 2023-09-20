package com.ktwitter.impl.assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListAssertions {
    public static void assertEquals(List<Integer> expected, List<Integer> actual) {
        if (expected.size() != actual.size()) {
            fail("expected (size %d) and actual (size %d) are not of same size".formatted(expected.size(), actual.size()));
        } else {
            StringBuffer diffs = new StringBuffer();
            for (int i=0 ; i<expected.size() ; i++) {
                if (expected.get(i) != actual.get(i)) {
                    if (!diffs.isEmpty())
                        diffs.append(" ; ");
                    diffs.append("expected[%d] != actual[%d]".formatted(i,i));
                }
            }
            if (!diffs.isEmpty()) {
                fail(diffs.toString());
            }
        }
    }
}
