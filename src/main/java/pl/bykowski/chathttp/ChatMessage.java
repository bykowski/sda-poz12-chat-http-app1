package pl.bykowski.chathttp;

public class ChatMessage {

    private String username;
    private String value;

    public ChatMessage(String username, String value) {
        this.username = username;
        this.value = value;
    }

    public ChatMessage() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "username='" + username + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
