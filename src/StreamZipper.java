import java.util.stream.Stream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

class Alternator implements Iterator{

    private Iterator fIterator;
    private Iterator sIterator;
    private boolean fromFirst;
    private boolean hasNext;

    Alternator(Iterator fIterator, Iterator sIterator) {
        this.fIterator = fIterator;
        this.sIterator = sIterator;
        fromFirst = true;
        hasNext = true;
    }

    @Override
    public boolean hasNext() {
        if (hasNext) {
            if (fIterator.hasNext() != sIterator.hasNext()) hasNext = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object result = (fromFirst)? fIterator.next() : sIterator.next();
        fromFirst = !fromFirst;
        return result;
    }

}

public class StreamZipper {

    public static Stream zip(Stream fStream, Stream sStream){
        Alternator alter = new Alternator(fStream.iterator(), sStream.iterator());
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(alter, Spliterator.ORDERED), false);
    }
}

