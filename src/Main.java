public class Main {

    public static void main(String[] args) {
        TextAppenderImpl tAI = new TextAppenderImpl();

        try {
            System.out.println("i am opening one");
            tAI.open("one");
            System.out.println("SUCCESS opened one");
        } catch (AlreadyExistsException e) {
            System.out.println("ERROR should have been able to open one");
        }

        System.out.println();

        try {
            System.out.println("i am opening one");
            tAI.open("one");
            System.out.println("ERROR should not have been able to open one");
        } catch (AlreadyExistsException e) {
            System.out.println("EXPECTED, one is already open");
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println("i am appending to one");
            tAI.append("one", "i am one");
            System.out.println("SUCCESS appended to one");
            System.out.println(tAI);
        } catch (DoesNotExistException e) {
            System.out.println("ERROR, one should exist");
        } catch (CannotAppendException e) {
            System.out.println("ERROR, should be able to append to one");
        }

        System.out.println();

        try {
            System.out.println("i am appending to yay");
            tAI.append("yay", "i am one");
            System.out.println("ERROR, yay does not exist");
        } catch (DoesNotExistException e) {
            System.out.println("EXPECTED, yay does not exist");
            System.out.println(e.getMessage());
        } catch (CannotAppendException e) {
            System.out.println("ERROR, should be able to append to one");
        }

        System.out.println();

        try {
            System.out.println("i am closing one");
            tAI.close("one");
            System.out.println("ERROR, one has not been flushed");
        } catch (DoesNotExistException e) {
            System.out.println("ERROR, one should exist");
        } catch (NeedsFlushException e) {
            System.out.println("EXPECTED, one has not been flushed");
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println("i am flushing two");
            tAI.flush("two");
            System.out.println("ERROR, two does not exist");
        } catch (DoesNotExistException e) {
            System.out.println("EXPECTED, two does not exist");
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println("appending emoji");
            tAI.appendEmoji("one",3);
            System.out.println("ERROR, should not be able to append index 3");
            System.out.println(tAI);
        } catch (DoesNotExistException e) {
            System.out.println("ERROR, one exists");
        } catch (CannotAppendException e) {
            System.out.println("EXPECTED, could not append index 3");
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println("appending emoji");
            tAI.appendEmoji("one",2);
            System.out.println("SUCCESS appended emoji");
            System.out.println(tAI);
        } catch (DoesNotExistException e) {
            System.out.println("ERROR, one exists");
        } catch (CannotAppendException e) {
            System.out.println("ERROR, emoji index exists");
        }

        System.out.println();

        try {
            System.out.println("i am flushing one");
            tAI.flush("one");
            System.out.println("SUCCESS flushed one");
            System.out.println(tAI);
        } catch (DoesNotExistException e) {
            System.out.println("ERROR, one should exist");
        }

        System.out.println();

        try {
            System.out.println("i am closing one");
            tAI.close("one");
            System.out.println("SUCCESS closed one");
            System.out.println(tAI);
        } catch (DoesNotExistException e) {
            System.out.println("ERROR, one should exist");
        } catch (NeedsFlushException e) {
            System.out.println("ERROR, one has been flushed");
        }
    }
}
