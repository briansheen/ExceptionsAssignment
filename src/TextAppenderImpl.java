import javax.xml.soap.Text;
import java.util.Arrays;
import java.util.MissingResourceException;

/**
 * Created by bsheen on 4/3/17.
 */
public class TextAppenderImpl implements TextAppender {

    private TextContainer[] list = new TextContainer[10];
    private Emojis emojis = new Emojis();


    @Override
    public void open(String key) throws AlreadyExistsException {
        int index = -1;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == null) {
                index = i;
                break;
            }
            if (list[i].getKey().equals(key)) {
                throw new AlreadyExistsException(key + " already exists");
            }
        }
        TextContainer tC = new TextContainer(key);
        list[index] = tC;

    }

    @Override
    public void append(String key, String text) throws DoesNotExistException, CannotAppendException {
        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null) {
                if (list[i].getKey().equals(key)) {
                    list[i].append(text);
                    return;
                }
            } else {
                break;
            }
        }
        throw new DoesNotExistException(key + " does not exist");
    }

    @Override
    public void appendEmoji(String key, int emojiIndex) throws DoesNotExistException, CannotAppendException {

        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null) {
                if (list[i].getKey().equals(key)) {
                    try{
                        emojis.getEmoji(emojiIndex);
                    }catch(MissingResourceException e) {
                        throw new CannotAppendException("cannot append " + e.getMessage(), e);
                    }
                    list[i].append(emojis.getEmoji(emojiIndex));
                    return;
                }
            } else {
                break;
            }
        }
        throw new DoesNotExistException(key + " does not exist");


    }

    @Override
    public void flush(String key) throws DoesNotExistException {
        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null) {
                if (list[i].getKey().equals(key)) {
                    list[i].flush();
                    return;
                }
            } else {
                break;
            }
        }
        throw new DoesNotExistException(key + " does not exist");
    }

    @Override
    public void close(String key) throws DoesNotExistException, NeedsFlushException {

        for (int i = 0; i < list.length; ++i) {
            if (list[i] != null) {
                if (list[i].getKey().equals(key)) {
                    if (list[i].isFlushed() == true) {
                        return;
                    } else {
                        throw new NeedsFlushException(key + " needs to be flushed before closing");
                    }
                }
            }
        }
        throw new DoesNotExistException(key + " does not exist");

    }

    @Override
    public String toString() {
        return "TextAppenderImpl{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
