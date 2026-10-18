'''java
public class Message {
    private String messageID;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    private static int totalMessagesSent = 0;

    // Constructor
    public Message(String messageID, String recipientCell, String messageText) {
        this.messageID = messageID;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // Check Message ID (not more than 10 characters)
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // Check Recipient Cell (no more than 10 characters and starts with code)
    public boolean checkRecipientCell() {
        return recipientCell != null && recipientCell.length() <= 10 && (recipientCell.startsWith("+") || recipientCell.matches("^[0-9]+$"));
    }

    // Check Message Length (must not exceed 250 characters)
    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }

    // Create Message Hash
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2 || messageText == null || messageText.isBlank()) {
            return "00:0:HASH";
        }
        String idPrefix = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        
        return (idPrefix + ":" + totalMessagesSent + ":" + firstWord + lastWord).toUpperCase();
    }

    // Getters
    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    public static void incrementTotalMessages() {
        totalMessagesSent++;
    }
}
```

