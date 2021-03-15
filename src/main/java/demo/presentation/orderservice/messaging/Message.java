package demo.presentation.orderservice.messaging;

public class Message {
    private String item;

    public Message() {
    }

    public Message(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
