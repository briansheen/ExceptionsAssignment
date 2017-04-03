/**
 * Created by bsheen on 4/3/17.
 */
public class TextContainer {
    private String key;
    private String text = "";
    private boolean flushed;

    public TextContainer(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public boolean isFlushed() {
        return flushed;
    }

    public void append(String value) {
        this.text = this.text + value;
    }

    public void flush(){
        this.flushed = true;
    }


    @Override
    public String toString() {
        return "TextContainer{" +
                "key='" + key + '\'' +
                ", text='" + text + '\'' +
                ", flushed=" + flushed +
                '}';
    }
}
