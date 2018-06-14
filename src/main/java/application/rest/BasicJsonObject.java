package application.rest;


public class BasicJsonObject {

    private final long id;
    private final String content;

    public BasicJsonObject(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}