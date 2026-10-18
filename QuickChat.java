import javax.swing.JOptionPane;

public class QuickChat {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");

        boolean running = true;

        while (running) {
            String menuOption = JOptionPane.showInputDialog(
                "Select an option:\n" +
                "1. Send Message\n" +
                "2. Show Recently Sent Messages (Coming Soon)\n" +
                "3. Quit"
            );

            if (menuOption == null || menuOption.equals("3")) {
                running = false;
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            }

            switch (menuOption) {
                case "1":
                    sendMessage();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }

    private static void sendMessage() {
        String messageID = JOptionPane.showInputDialog("Enter Message ID (Max 10 characters):");
        if (messageID == null) return;

        String recipientCell = JOptionPane.showInputDialog("Enter Recipient Cell Number (e.g. +27831234567):");
        if (recipientCell == null) return;

        String messageText = JOptionPane.showInputDialog("Enter Message (Max 250 characters):");
        if (messageText == null) return;

        Message message = new Message(messageID, recipientCell, messageText);

        if (!message.checkMessageID()) {
            JOptionPane.showMessageDialog(null, "Error: Message ID must not exceed 10 characters.");
            return;
        }

        if (!message.checkRecipientCell()) {
            JOptionPane.showMessageDialog(null, "Error: Recipient number is invalid. It must start with '+' followed by country code and digits.");
            return;
        }

        if (!message.checkMessageLength()) {
            JOptionPane.showMessageDialog(null, "Error: Message exceeds 250 character limit.");
            return;
        }

        Message.incrementTotalMessages();
        String hash = message.createMessageHash();

        String details = "Message Sent Successfully!\n\n" +
                         "Message ID: " + message.getMessageID() + "\n" +
                         "Recipient: " + message.getRecipientCell() + "\n" +
                         "Message: " + message.getMessageText() + "\n" +
                         "Message Hash: " + hash;

        JOptionPane.showMessageDialog(null, details);
    }
}
