package org.loglang.token;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.loglang.util.PropertyReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liumiao on 16-5-14.
 */
public class Token {
    private static Set<Character> beginTokens;
    private static Set<Character> endTokens;
    private static Set<String> optTokens;
    private static Set<Character> patternTokens;
    private static Set<Character> patternBeginTokens;
    private static Set<Character> patternEndTokens;
    private static Set<Character> blankTokens;

    private void initTokens() throws IOException {
        beginTokens = new HashSet<Character>();
        endTokens = new HashSet<Character>();
        patternTokens = new HashSet<Character>();
        patternBeginTokens = new HashSet<Character>();
        patternEndTokens = new HashSet<Character>();
        optTokens = new HashSet<String>();
        blankTokens = new HashSet<Character>();
        PropertyReader reader = new PropertyReader("conf/tokens.properties");
        CollectionUtils.addAll(beginTokens, reader.getCharacters("tokens.begin"));
        CollectionUtils.addAll(endTokens, reader.getCharacters("tokens.end"));
        CollectionUtils.addAll(patternTokens, reader.getCharacters("tokens.pattern"));
        CollectionUtils.addAll(patternBeginTokens, reader.getCharacters("tokens.pattern.begin"));
        CollectionUtils.addAll(patternEndTokens, reader.getCharacters("tokens.pattern.end"));
        CollectionUtils.addAll(optTokens, reader.getArray("tokens.operation", ","));
        CollectionUtils.addAll(blankTokens, reader.getCharacters("tokens.blank"));
    }
}
