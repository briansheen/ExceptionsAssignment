/**
 * Created by bsheen on 4/3/17.
 */
public interface TextAppender {
    void open(String key) throws AlreadyExistsException;
    void append(String key, String text) throws DoesNotExistException, CannotAppendException;
    void appendEmoji(String key, int emojiIndex) throws DoesNotExistException, CannotAppendException;
    void flush(String key) throws DoesNotExistException;
    void close(String key) throws DoesNotExistException, NeedsFlushException;
}
