// Program: Twitter Trends
import java.util.*;
// import java.io.*;

// This class lets the user use their list of tweets
// and see specific things like what the most frequent word is in
// their list or see if there are any tweets with misinformation about COVID-19.
public class TwitterTrends {
    private TweetBot bot; 

    // Constructor so we can use the methods of TweetBot in this class
    // parameter:
    //      - bot: gives us access to the list of tweets and instance methods in TweetBot.java
    public TwitterTrends(TweetBot bot){
        this.bot = bot;
    }

    // This instance method finds the most frequently appearing
    // word in the list of tweets and returns that word.
    public String getMostFrequentWord(){
        Map<String,Integer> wordsKeepTrack = new HashMap<>();
        String frequentWord = "";
        int frequentCount = 0;
        int numberOfTweets = this.bot.numTweets();
        while(numberOfTweets != 1){
            Scanner wordInput = new Scanner(this.bot.nextTweet());
            while(wordInput.hasNext()){
                String word = (wordInput.next()).toLowerCase();
                if(!wordsKeepTrack.containsKey(word)){
                    wordsKeepTrack.put(word,0);
                }
                wordsKeepTrack.put(word, wordsKeepTrack.get(word)+1);
            }
            numberOfTweets--;
        }
        for(String word : wordsKeepTrack.keySet()){
            if ((wordsKeepTrack.get(word)) > frequentCount){
                frequentCount = wordsKeepTrack.get(word);
                frequentWord = word;
            }
        }
        return frequentWord;
    }

    // This instance method finds tweets that can contain
    // misinformation about COVID-19 and gives the user a warning.
    public void flagMisinfo(){
        int numberOfTweets = this.bot.numTweets();
        while(numberOfTweets != 0){
            String line = this.bot.nextTweet().toLowerCase();
            if(line.contains("covid") || line.contains("the pandemic")){
                System.out.println("Tweet: " + line);
                System.out.println("Disclaimer of misinformation!");
                System.out.println("Please visit: https://bit.ly/3Glisil");
            }
            numberOfTweets--;
        }
        bot.reset();
    }
}
