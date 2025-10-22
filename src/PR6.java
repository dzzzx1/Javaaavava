import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class PR6 {
    public static void main(String[] args) {
        String[] chat = {
                "12:01 Anna: Привет @Ivan! #home",
                "12:05 Ivan: @Anna давай в #office #work",
                "12:10 Bob: email@test.com не путать с @user",
                "12:15 Anna: @Ivan @Bob встреча в #office #meeting"
        };

        Pattern msgPattern = Pattern.compile("(\\d+:\\d+)\\s+(\\w+):\\s*(.+)");
        Pattern mentionPattern = Pattern.compile("(?<![\\w@])@(\\w+)");
        Pattern hashtagPattern = Pattern.compile("#(\\w+)");

        Map<String, Integer> userMessages = new HashMap<>();
        Map<String, Integer> userMentions = new HashMap<>();
        Map<String, Integer> hashtagCount = new HashMap<>();

        for (String line : chat) {
            Matcher msgMatcher = msgPattern.matcher(line);
            if (msgMatcher.find()) {
                String user = msgMatcher.group(2);
                String text = msgMatcher.group(3);

                userMessages.put(user, userMessages.getOrDefault(user, 0) + 1);

                Matcher mentionMatcher = mentionPattern.matcher(text);
                while (mentionMatcher.find()) {
                    String mentionedUser = mentionMatcher.group(1);
                    userMentions.put(mentionedUser, userMentions.getOrDefault(mentionedUser, 0) + 1);
                }

                Matcher hashtagMatcher = hashtagPattern.matcher(text);
                while (hashtagMatcher.find()) {
                    String hashtag = hashtagMatcher.group(1);
                    hashtagCount.put(hashtag, hashtagCount.getOrDefault(hashtag, 0) + 1);
                }
            }
        }

        System.out.println("АКТИВНОСТЬ ПОЛЬЗОВАТЕЛЕЙ:");
        userMessages.forEach((user, count) -> {
            int mentions = userMentions.getOrDefault(user, 0);
            System.out.printf("%s: %d сообщений, %d упоминаний%n", user, count, mentions);
        });

        System.out.println("\nТОП-3 ХЭШТЕГА:");
        hashtagCount.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e -> System.out.printf("#%s: %d раз%n", e.getKey(), e.getValue()));
    }
}