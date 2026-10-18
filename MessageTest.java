```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckMessageID_Valid() {
        Message msg = new Message("MSG01", "+27831234567", "Hello world");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckMessageID_Invalid() {
        Message msg = new Message("TOOLONGMESSAGEID", "+27831234567", "Hello world");
        assertFalse(msg.checkMessageID());
    }

    @Test
    public void testCheckRecipientCell_Valid() {
        Message msg = new Message("MSG01", "+27831234567", "Hello world");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Invalid() {
        Message msg = new Message("MSG01", "0831234567890", "Hello world");
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testCheckMessageLength_Valid() {
        Message msg = new Message("MSG01", "+27831234567", "This is a short message.");
        assertTrue(msg.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_Invalid() {
        String longText = "A".repeat(251);
        Message msg = new Message("MSG01", "+27831234567", longText);
        assertFalse(msg.checkMessageLength());
    }

    @Test
    public void testCreateMessageHash() {
        Message.incrementTotalMessages();
        Message msg = new Message("RC1", "+27831234567", "This is a test message");
        assertNotNull(msg.createMessageHash());
    }
}
```


       











































