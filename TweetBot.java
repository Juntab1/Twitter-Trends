// Program: Twitter Trends
import java.util.*;
// import java.io.*;

// This class is able to read through and manipulate a list of tweets.
// The class has functions to read through the tweets, add tweets to the list,
// remove tweets, see how many tweets there are, and reset where we are in the list of tweets.
// To do all that the class takes in a tweet file with tweets in it.
public class TweetBot {
    private List<String> tweets;
    private int countList;

    // The constructor initializes the list of tweets from the client file that contains
    // tweets.
    // parameter:
    //      - tweets: the list of tweets from the tweets.txt file
    // IllegalArgumentException for when the list of words has a size of less than 1.
    public TweetBot(List<String> tweets){
        if (tweets.size() < 1){
            throw new IllegalArgumentException();
        }
        this.tweets = new ArrayList<>();
        for (int i = 0; i < tweets.size(); i++){ 
            this.tweets.add(tweets.get(i));
        }
    }

    // Instance method where the number of tweets our current list of tweets has is returned.
    public int numTweets(){
        return tweets.size();
    }

    // Instance method where we can add a tweet to the end of our list of tweets.
    // parameter:
    //      - tweet: the clients passed in tweet 
    public void addTweet(String tweet){
        this.tweets.add(tweet);
    }

    // Loops through our list of tweets and if we end up looking at the last tweet,
    // we are looped back to the beginning of the list.
    // Returns the actual tweet we are currently at.
    public String nextTweet(){
        if (this.countList == this.tweets.size()){
            this.countList = 0;
        }
        int currentNum = this.countList;
        this.countList++;
        return this.tweets.get(currentNum);

    }

    // The instance method removes a tweet that the client
    // passed in from our list of tweets. The index we are 
    // currently at for the list of tweets is updated.
    // parameter:
    //      - tweet: the client's passed in tweet 
    public void removeTweet(String tweet){
        if (this.tweets.contains(tweet)){
            if(this.countList > this.tweets.indexOf(tweet)){
                this.countList--;
            }
            this.tweets.remove(tweet);
        }
    }

    // The instance method sets where we currently are in  
    // the list of tweets back to the beginning of the list.
    public void reset(){
        this.countList = 0;
    }
}   