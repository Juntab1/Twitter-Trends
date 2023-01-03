// Program: Twitter Trends
import java.util.*;
import java.io.*;

public class TwitterMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("tweets.txt")); // Make Scanner over tweet file
        List<String> tweets = new ArrayList<>();
        while (input.hasNextLine()) { // Add each tweet in file to List
            tweets.add(input.nextLine());
        }

        TweetBot bot = new TweetBot(tweets); // Create TweetBot object with list of tweets
        TwitterTrends trends = new TwitterTrends(bot); // Create TwitterTrends object

        // TODO: Call and display results from getMostFrequentWord and your
        // creative method here
        System.out.println("Most Frequent Word: " + trends.getMostFrequentWord());
        trends.flagMisinfo();
    }
}
